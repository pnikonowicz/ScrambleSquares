import java.util.List;

public class Card {
    private final int id;
    private final List<Side> sides;

    public Card(int id, List<Side> sides) {
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

    public Side getRightSide() {
        return sides.get(1);
    }

    public Side getBottomSide() {
        return sides.get(2);
    }

    public Side getLeftSide() {
        return sides.get(3);
    }

    public Side getTopSide() {
        return sides.get(0);
    }
}
