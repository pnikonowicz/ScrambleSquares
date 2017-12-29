import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardTest {
    @Test
    public void toStringWorks() {
        Card card = new Card(2, Arrays.asList("A", "B"));
        String result = card.toString();

        Assertions.assertEquals("id: 2 | sides: [A, B]", result);
    }
}
