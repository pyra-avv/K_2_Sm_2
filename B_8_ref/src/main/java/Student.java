import java.util.Objects;

public class Student extends Human implements Executable{
    private final String faculty;
    private final String university;
    private final String speciality;
    public Student(String surname, String name, String patronymic,
                   String faculty, String university, String speciality) {
        super(surname, name,  patronymic);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty) && Objects.equals(university, student.university) && Objects.equals(speciality, student.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, university, speciality);
    }

    @Override
    public void execute() {
    }
}
