import java.util.Objects;

public class Side {
    private String value;
    private Polarity polarity;

    public Side(String value, Polarity polarity) {
        this.value = value;
        this.polarity = polarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Side side = (Side) o;
        return Objects.equals(value, side.value);
    }

    @Override
    public String toString() {
        return String.format("%s%s", value, this.polarity==Polarity.Negative?"-":"+");
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean matches(Side side) {
        Polarity polarity = this.polarity==Polarity.Negative?Polarity.Positive:Polarity.Negative;
        return side.value==side.value && polarity==side.polarity;
    }
}
