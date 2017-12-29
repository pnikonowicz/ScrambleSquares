import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import java.util.Arrays;

public class CardBoardTest {
    Side genericSide = new Side("_", Polarity.Negative);
    Side positiveSide = new Side("X", Polarity.Positive);
    Side negativeSide = new Side("X", Polarity.Negative);

    @Test
    public void isFull() {
        Card card = new Card(3, Arrays.asList(genericSide,genericSide,genericSide,genericSide));

        CardBoard cardBoard = new CardBoard(card)
                .place(card)
                .place(card)
                .place(card)
                .place(card)
                .place(card)
                .place(card)
                .place(card);

        Assertions.assertFalse(cardBoard.isFull());
        Assertions.assertTrue(cardBoard.place(card).isFull());
    }

    @Test
    public void placeReturnsAnotherBoard() {
        Card card = new Card(3, Arrays.asList());
        CardBoard cardBoard = new CardBoard();
        CardBoard result = cardBoard.place(card);

        Assertions.assertNotSame(cardBoard, result);
        Assertions.assertFalse(cardBoard.areEqual(result));
        Assertions.assertTrue(new CardBoard(card).areEqual(result));
    }

    @Test
    public void canPlaceFirstRowFirstItemGood() {
        Card card = new Card(3, Arrays.asList(genericSide, positiveSide, genericSide, genericSide));
        Card goodCardToPlace = new Card(3, Arrays.asList(genericSide,genericSide,genericSide,negativeSide));
        CardBoard cardBoard = new CardBoard(card);

        Assertions.assertTrue(cardBoard.canPlace(goodCardToPlace));
    }

    @Test
    public void canPlaceFirstRowFirstItemBad() {
        Card card = new Card(3, Arrays.asList(genericSide,positiveSide,genericSide,genericSide));
        Card goodCardToPlace = new Card(3, Arrays.asList(genericSide,genericSide,genericSide,positiveSide));
        CardBoard cardBoard = new CardBoard(card);

        Assertions.assertFalse(cardBoard.canPlace(goodCardToPlace));
    }

    @Test
    public void canPlaceFirstRowThirdItemGood() {
        Card cardA = new Card(3, Arrays.asList(genericSide,genericSide,positiveSide,genericSide));
        Card cardB = new Card(5, Arrays.asList(genericSide,genericSide,genericSide,genericSide));
        Card cardC = new Card(5, Arrays.asList(genericSide,genericSide,genericSide,genericSide));

        Card goodCardToPlace = new Card(3, Arrays.asList(negativeSide,genericSide,genericSide,genericSide));
        CardBoard cardBoard = new CardBoard(cardA).place(cardB).place(cardC);

        Assertions.assertTrue(cardBoard.canPlace(goodCardToPlace));
    }

    @Test
    public void canPlaceFirstRowThirdItemBad() {
        Card cardA = new Card(3, Arrays.asList(genericSide,genericSide,genericSide,genericSide));
        Card cardB = new Card(5, Arrays.asList(genericSide,genericSide,genericSide,genericSide));
        Card cardC = new Card(5, Arrays.asList(genericSide,genericSide,genericSide,genericSide));

        Card goodCardToPlace = new Card(3, Arrays.asList(genericSide,genericSide,genericSide,genericSide));
        CardBoard cardBoard = new CardBoard(cardA).place(cardB).place(cardC);

        Assertions.assertFalse(cardBoard.canPlace(goodCardToPlace));
    }
}
