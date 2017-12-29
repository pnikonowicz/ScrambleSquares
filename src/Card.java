import java.util.List;
import java.util.stream.Collectors;

public class Card {
    private final int id;
    private final List<Side> sides;

    public Card(int id, List<String> sides) {
        this.id = id;
        this.sides = sides.stream().map(x -> new Side(x)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String template = "id: %s | sides: %s";
        return String.format(template, id, sides);
    }

    public Card rotate() {
        return null;
    }

    public Card[] rotations() {
        return new Card[]{rotate(), rotate(), rotate(), rotate()};
    }

    public Side getRightSide() {
        return sides.get(1);
    }
}
