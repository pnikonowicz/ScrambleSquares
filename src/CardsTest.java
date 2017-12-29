import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardsTest {
    @Test
    public void except() {
        Side side = new Side("_", Polarity.Top);
        Card cardA = new Card(1, Arrays.asList(side,side,side,side));
        Card cardB = new Card(2, Arrays.asList(side,side,side,side));
        Cards cards = new Cards();
        cards.add(cardA);
        cards.add(cardB);

        Cards result = cards.except(cardA);

        Assertions.assertEquals(result.size(),1);
        Assertions.assertEquals(cardB, result.get(0));
    }
}
