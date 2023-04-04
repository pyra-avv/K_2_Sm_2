import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect
public class House implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String cadastralNumber;
    private String addres;
    private Person senior;
    private List<Flat> flats;
    public House() {
    }
    public House(String cadastralNumber, String addres, Person senior, Flat... flats) {
        this.cadastralNumber = cadastralNumber;
        this.addres = addres;
        this.senior = senior;
        this.flats = new ArrayList<>(List.of(flats));
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Person getSenior() {
        return senior;
    }

    public void setSenior(Person senior) {
        this.senior = senior;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
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
