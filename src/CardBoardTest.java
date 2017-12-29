import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardBoardTest {
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
    public void nextEdgeForFirstRowFirstItem() {
        Card card = new Card(3, Arrays.asList("1","2","3","4"));
        CardBoard cardBoard = new CardBoard(card);

        Side result = cardBoard.getNextEdge();

        Assertions.assertEquals(new Side("2"), result);
    }

    @Test
    public void nextEdgeForFirstRowThirdItem() {
        Card cardA = new Card(3, Arrays.asList("_","_","X","_"));
        Card cardB = new Card(5, Arrays.asList("_","_","_","_"));
        Card cardC = new Card(5, Arrays.asList("_","_","_","_"));
        CardBoard cardBoard = new CardBoard().place(cardA).place(cardB).place(cardC);

        Side result = cardBoard.getNextEdge();

        Assertions.assertEquals(new Side("X"), result);
    }
}
