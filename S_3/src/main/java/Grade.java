import java.util.Objects;

public class Grade {
    private final int grade;

    public Grade(int grade) {
        if (grade < 0 || grade > 5) {
            throw new NullPointerException("Некорректная оценка");
        }
        this.grade = grade;
    }
    public int getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        String[] arrG = { "Незачтено", "Зачтено", "Неудовлетворительно", "Удовлетворительно", "Хорошо", "Отлично" };
        return arrG[grade];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return grade == grade1.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade);
    }
}
