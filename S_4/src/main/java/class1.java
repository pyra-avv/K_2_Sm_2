import java.util.Objects;

public class class1 {
    private int i;

    public class1(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        class1 class1 = (class1) o;
        return i == class1.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
