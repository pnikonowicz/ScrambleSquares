import java.util.List;

public class Card {
    private final int id;
    private final List<String> sides;

    public Card(int id, List<String> sides) {
        this.id = id;
        this.sides = sides;
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
}
