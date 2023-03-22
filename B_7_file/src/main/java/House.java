import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String cadastralNumber;
    private final String addres;
    private final Person senior;
    private final List<Flat> flats;
    public House(String cadastralNumber, String addres, Person senior, Flat... flats) {
        this.cadastralNumber = cadastralNumber;
        this.addres = addres;
        this.senior = senior;
        this.flats = new ArrayList<>(List.of(flats));
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public String getAddres() {
        return addres;
    }

    public Person getSenior() {
        return senior;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNumber, house.cadastralNumber) && Objects.equals(addres, house.addres) && Objects.equals(senior, house.senior) && Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, addres, senior, flats);
    }
}
