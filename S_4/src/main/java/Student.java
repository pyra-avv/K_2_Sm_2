import java.io.Serializable;
import java.util.Objects;

public class Student extends Person implements Serializable {
    private final String group;
    public Student() {
        super();
        this.group = "group";
    }
    public Student(String name, String group) {
        super(name);
        this.group = group;
    }
    String getGroupName() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }
}
