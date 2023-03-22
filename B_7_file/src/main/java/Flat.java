import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int room;
    private final int S;
    private final List<Person> tenants;
    public Flat(int room, int S, Person... tenants) {
        this.room = room;
        this.S = S;
        this.tenants = new ArrayList<>(List.of(tenants));
    }

    public int getRoom() {
        return room;
    }

    public int getS() {
        return S;
    }

    public List<Person> getTenants() {
        return tenants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return room == flat.room && S == flat.S && Objects.equals(tenants, flat.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, S, tenants);
    }
}
