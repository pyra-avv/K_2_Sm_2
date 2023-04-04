import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect
public class Flat implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int room;
    private int S;
    private List<Person> tenants;
    public Flat() {
    }
    public Flat(int room, int S, Person... tenants) {
        this.room = room;
        this.S = S;
        this.tenants = new ArrayList<>(List.of(tenants));
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public List<Person> getTenants() {
        return tenants;
    }

    public void setTenants(List<Person> tenants) {
        this.tenants = tenants;
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
