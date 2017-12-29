import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cards extends ArrayList<Card> {

    public static Cards generateCards() {
        return null;
    }

    public Cards except(Card card) {
        return this.stream().filter(x -> x.getId() != card.getId()).collect(Collectors.toCollection(Cards::new));
    }
}
