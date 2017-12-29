import javafx.util.Pair;

import java.util.Arrays;

public class CardBoard {
    private Card[][] cards = new Card[3][3];

    public CardBoard(Card card) {
        cards[0][0]=card;
    }

    public CardBoard() {
    }

    public CardBoard place(Card card) {
        CardBoard newBoard = new CardBoard();
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if(cards[i][j]!=null) {
                    newBoard.cards[i][j] = new Card(cards[i][j].getId(), cards[i][j].getSides());
                } else {
                    cards[i][j] = null;
                }
            }
        }

        Pair<Integer, Integer> next = getNextEmptyCoordinates();
        newBoard.cards[next.getKey()][next.getValue()] = new Card(card.getId(), card.getSides());
        return newBoard;
    }

    private Pair<Integer,Integer> getNextEmptyCoordinates() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j] == null)
                    return new Pair(i, j);
            }
        }
        throw new RuntimeException("CardBoard may be full");
    }

    public boolean isFull() {
        for (int i = 0; i < cards.length; i++)
            for (int j = 0; j < cards[i].length; j++)
                if(cards[i][j]==null)
                    return false;
        return true;
    }

    public boolean canPlace(Card cardToPlace) {
        Pair<Integer, Integer> cardCoordinates = getLastAddedCardCoordinates();
        if(cardCoordinates.getKey()==-1)
            return true;

        if (cardCoordinates.getKey()==0) {
            if(cardCoordinates.getValue()==0) {
                Card card = cards[cardCoordinates.getKey()][cardCoordinates.getValue()];
                return card.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==1) {
                Card card = cards[cardCoordinates.getKey()][cardCoordinates.getValue()];
                return card.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==2) {
                Card card = cards[0][0];
                return card.getBottomSide().matches(cardToPlace.getTopSide());
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else if(cardCoordinates.getKey()==1) {
            if(cardCoordinates.getValue()==0) {
                Card cardA = cards[0][1];
                Card cardB = cards[1][0];
                return cardA.getBottomSide().matches(cardToPlace.getTopSide())
                        && cardB.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==1) {
                Card cardA = cards[0][2];
                Card cardB = cards[1][1];
                return cardA.getBottomSide().matches(cardToPlace.getTopSide())
                        && cardB.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==2) {
                Card card = cards[1][0];
                return card.getBottomSide().matches(cardToPlace.getTopSide());
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else if(cardCoordinates.getKey()==2) {
            if(cardCoordinates.getValue()==0) {
                Card cardA = cards[1][1];
                Card cardB = cards[2][0];
                return cardA.getBottomSide().matches(cardToPlace.getTopSide())
                        && cardB.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==1) {
                Card cardA = cards[1][2];
                Card cardB = cards[2][1];
                return cardA.getBottomSide().matches(cardToPlace.getTopSide())
                        && cardB.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==2) {
                throw new RuntimeException("board is full");
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else {
            throw new RuntimeException("unsupported row");
        }
    }

    public boolean areEqual(CardBoard obj) {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if(obj.cards[i][j]!=null && !obj.cards[i][j].equals(cards[i][j]))
                    return false;
            }
        }
        return true;
    }

    public Pair<Integer,Integer> getLastAddedCardCoordinates() {
        int lastI=-1;
        int lastJ=-1;
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j] == null) {
                    return new Pair(lastI, lastJ);
                } else {
                    lastI=i;
                    lastJ=j;
                }
            }
        }
        throw new RuntimeException("CardBoard may be full");
    }

    public int size() {
        int count =0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if(cards[i][j]!=null)
                    count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                sb.append(cards[i][j]);
                sb.append("|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
