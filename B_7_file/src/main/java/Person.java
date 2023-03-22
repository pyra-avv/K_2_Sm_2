import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String surname;
    private final String name;
    private final String patronymic;
    Data birthday;
    public Person(String surname, String name, String patronymic, Data birthday) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Data getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(name, person.name) && Objects.equals(patronymic, person.patronymic) && Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, birthday);
    }
}
