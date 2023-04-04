import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@JsonAutoDetect
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String surname;
    private String name;
    private String patronymic;
    Data birthday;
    public Person() {
    }
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
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
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
