public class CardBoard {
    private Card[][] cards = new Card[3][3];

    public CardBoard(Card card) {
        cards = place(card).cards;
    }

    public CardBoard() {
    }

    public CardBoard place(Card card) {
        CardBoard newBoard = new CardBoard();
        for (int i = 0; i < cards.length; i++)
            for (int j = 0; j < cards[i].length; j++) {
                newBoard.cards[i][j] = card;
            }
        return newBoard;
    }

    public Edge getNextEdge() {
        return null;
    }

    public Card pop() {
        return null;
    }

    public boolean isFull() {
        throw new RuntimeException("TODO");
    }

    public boolean canPlace(Card card) {
        throw new RuntimeException("TODO");
    }

    public boolean areEqual(CardBoard obj) {
        for (int i = 0; i < cards.length; i++)
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j] != obj.cards[i][j])
                    return false;
            }
        return true;
    }
}
