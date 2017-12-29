public class Main {
    public static void main(String args[]) {
        Cards cards = Cards.generateCards();

        CardBoard solvedBoard = solveGame(cards);

        System.out.println("DONE");
        System.out.println(solvedBoard);
    }

    private static CardBoard solveGame(Cards cards) {
        return fillCardBoard(new CardBoard(), cards);
    }

    public static CardBoard fillCardBoard(CardBoard cardBoard, Cards cards) {


        for(Card nextCard : cards) {
            for (Card rotatingCard : nextCard.rotations()) {
                if (cardBoard.canPlace(rotatingCard)) {
                    CardBoard filledCardboard = fillCardBoard(cardBoard.place(rotatingCard), cards.except(rotatingCard));
                    if (filledCardboard.isFull()) {
                        return filledCardboard;
                    }
                    else {
                    }
                } else {
                }
            }
        }
        return cardBoard;
    }
}
