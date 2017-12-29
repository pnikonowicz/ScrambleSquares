import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardTest {
    @Test
    public void rotate() {
        Side s1=new Side("1", Polarity.Negative);
        Side s2=new Side("2", Polarity.Negative);
        Side s3=new Side("3", Polarity.Negative);
        Side s4=new Side("4", Polarity.Negative);

        Card c = new Card(1, Arrays.asList(s1,s2,s3,s4));
        Card result = c.rotate();
        Card expected = new Card(1, Arrays.asList(s2,s3,s4,s1));

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void rotations() {
        Side s1=new Side("1", Polarity.Negative);
        Side s2=new Side("2", Polarity.Negative);
        Side s3=new Side("3", Polarity.Negative);
        Side s4=new Side("4", Polarity.Negative);

        Card c = new Card(1, Arrays.asList(s1,s2,s3,s4));
        Card[] result = c.rotations();
        Card expected = new Card(1, Arrays.asList(s2,s3,s4,s1));

        Assertions.assertEquals(result, expected);
    }
}
