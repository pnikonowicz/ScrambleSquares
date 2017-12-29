import javafx.util.Pair;

public class CardBoard {
    private Card[][] cards = new Card[3][3];

    public CardBoard(Card card) {
        cards = place(card).cards;
    }

    public CardBoard() {
    }

    public CardBoard place(Card card) {
        CardBoard newBoard = new CardBoard();
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                newBoard.cards[i][j] = cards[i][j];
            }
        }

        Pair<Integer, Integer> next = getNextEmptyCoordinates();
        newBoard.cards[next.getKey()][next.getValue()] = card;
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

        if (cardCoordinates.getKey()==0) {
            if(cardCoordinates.getValue()==0) {
                Card card = cards[cardCoordinates.getKey()][cardCoordinates.getValue()];
                return card.getRightSide().matches(cardToPlace.getLeftSide());
            } else if(cardCoordinates.getValue()==1) {
                return false;
            } else if(cardCoordinates.getValue()==2) {
                Card card = cards[0][0];
                return card.getBottomSide().matches(cardToPlace.getTopSide());
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else if(cardCoordinates.getKey()==1) {
            if(cardCoordinates.getValue()==0) {
                Card cardA = cards[0][1];
                Card cardB = cards[0][0];
                return cardA.getBottomSide().matches(cardToPlace.getTopSide())
                        && cardB.getRightSide().matches(cardA.getLeftSide());
            } else if(cardCoordinates.getValue()==1) {
                throw new RuntimeException("TODO");
            } else if(cardCoordinates.getValue()==2) {
                throw new RuntimeException("TODO");
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else if(cardCoordinates.getKey()==2) {
            if(cardCoordinates.getValue()==0) {
                throw new RuntimeException("TODO");
            } else if(cardCoordinates.getValue()==1) {
                throw new RuntimeException("TODO");
            } else if(cardCoordinates.getValue()==2) {
                throw new RuntimeException("TODO");
            } else {
                throw new RuntimeException("Invalid column");
            }
        } else {
            throw new RuntimeException("unsupported row");
        }
    }

    public boolean areEqual(CardBoard obj) {
        for (int i = 0; i < cards.length; i++)
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j] != obj.cards[i][j])
                    return false;
            }
        return true;
    }

    public Pair<Integer,Integer> getLastAddedCardCoordinates() {
        int lastI=0;
        int lastJ=0;
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
}
