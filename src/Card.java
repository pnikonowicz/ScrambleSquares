import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Side> rotated = new ArrayList(sides);
        Side s = rotated.remove(0);
        rotated.add(s);
        return new Card(id, rotated);
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                Objects.equals(sides, card.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sides);
    }
}
