import java.util.Objects;

public class Grade {
    private final int grade;

    public Grade(int grade) {
        if (grade < 0 || grade > 5) {
            throw new NullPointerException("Некорректная оценка");
        }
        this.grade = grade;
    }
    public int get() {
        return grade;
    }
    @Override
    public String toString() {
        if (grade == 5) {
            return "Отлично";
        }
        if (grade == 4) {
            return "Хорошо";
        }
        if (grade == 3) {
            return "Удовлетворительно";
        }
        if (grade == 1) {
            return "Зачтено";
        }
        if (grade == 0) {
            return "Незачтено";
        }
        return "Неудовлетворительно";
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
