public class Main {
    public static void main(String args[]) {
        Cards cards = Cards.generateCards();

        CardBoard solvedBoard = solveGame(cards);

        System.out.println("DONE");
        System.out.println(solvedBoard);
    }

    private static CardBoard solveGame(Cards cards) {
        for (Card first_card : cards) {
            for (Card card : first_card.rotations()) {
                CardBoard cardBoard = fillCardBoard(new CardBoard(card), cards.except(card));

                if (cardBoard.isFull()) {
                    return cardBoard;
                }
            }
        }
        return new CardBoard();
    }

    public static CardBoard fillCardBoard(CardBoard cardBoard, Cards cards) {
        if (cards.isEmpty() || cardBoard.isFull())
            return cardBoard;

        for(Card nextCard : cards) {
            for (Card rotatingCard : nextCard.rotations()) {
                if (cardBoard.canPlace(rotatingCard)) {
                    CardBoard filledCardboard = fillCardBoard(cardBoard.place(rotatingCard), cards.except(rotatingCard));
                    if (filledCardboard.isFull())
                        return filledCardboard;
                }
            }
        }
        return new CardBoard();
    }
}
