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
}
