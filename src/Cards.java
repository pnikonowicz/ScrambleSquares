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
        Side electricRed_T = new Side("ElectricRed", Polarity.Top);
        Side electricRed_B = new Side("ElectricRed", Polarity.Bottom);
        Side bass_T = new Side("Bass", Polarity.Top);
        Side bass_B = new Side("Bass", Polarity.Bottom);
        Side acoustic_T = new Side("Acoustic", Polarity.Top);
        Side acoustic_B = new Side("Acoustic", Polarity.Bottom);
        Side electricBlack_T = new Side("ElectricBlack", Polarity.Top);
        Side electricBlack_B = new Side("ElectricBlack", Polarity.Bottom);

        List<Card> cards = Arrays.asList(
                new Card(1, Arrays.asList(electricRed_B, electricBlack_T, acoustic_T, bass_B)),
                new Card(2, Arrays.asList(electricBlack_B, bass_B, electricRed_T, electricBlack_T)),
                new Card(3, Arrays.asList(acoustic_B, electricRed_T, acoustic_B, bass_T)),
                new Card(4, Arrays.asList(acoustic_T, electricRed_B, electricBlack_B, bass_T)),
                new Card(5, Arrays.asList(electricRed_B, acoustic_T, bass_B, electricBlack_T)),
                new Card(6, Arrays.asList(bass_B, bass_T, electricRed_T, acoustic_B)),
                new Card(7, Arrays.asList(bass_B, electricRed_B, electricBlack_T, acoustic_T)),
                new Card(8, Arrays.asList(electricRed_B, electricBlack_B, bass_B, acoustic_T)),
                new Card(9, Arrays.asList(acoustic_B, electricRed_B, electricBlack_T, electricBlack_T))
        );
        return cards.stream().collect(Collectors.toCollection(Cards::new));
    }

    public Cards except(Card card) {
        return this.stream().filter(x -> x.getId() != card.getId()).collect(Collectors.toCollection(Cards::new));
    }
}
