import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cards extends ArrayList<Card> {

    public static Cards generateCards() {
        /**
         * A|B|A
         * B|A|B
         * A|B|A
         */
        Side sideA = new Side("A", Polarity.Negative);
        Side sideB = new Side("A", Polarity.Positive);
        List<Card> cards = Arrays.asList(
                new Card(1, Arrays.asList(sideA, sideA, sideA, sideA)),
                new Card(2, Arrays.asList(sideB, sideB, sideB, sideB)),
                new Card(3, Arrays.asList(sideA, sideA, sideA, sideA)),
                new Card(4, Arrays.asList(sideB, sideB, sideB, sideB)),
                new Card(5, Arrays.asList(sideA, sideA, sideA, sideA)),
                new Card(6, Arrays.asList(sideB, sideB, sideB, sideB)),
                new Card(7, Arrays.asList(sideA, sideA, sideA, sideA)),
                new Card(8, Arrays.asList(sideB, sideB, sideB, sideB)),
                new Card(9, Arrays.asList(sideA, sideA, sideA, sideA))
        );
        return cards.stream().collect(Collectors.toCollection(Cards::new));
    }

    public Cards except(Card card) {
        return this.stream().filter(x -> x.getId() != card.getId()).collect(Collectors.toCollection(Cards::new));
    }
}
