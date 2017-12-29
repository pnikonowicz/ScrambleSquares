import java.util.Objects;

public class Side {
    private String value;

    public Side(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Side side = (Side) o;
        return Objects.equals(value, side.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Side{" +
                "value='" + value + '\'' +
                '}';
    }
}
