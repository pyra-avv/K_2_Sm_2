import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Reference {
    /**
     * Шапка:
     * Student student:
     * ФИО студента
     * название вуза
     * факультет
     * специальности;
     * период обучения:
     * Data start: дата начала
     * Data end: дата окончания
     */
    private Student student;
    private Data start;
    private Data end;
    /**
     * Табличная часть:
     * набор строк, каждая из которых содержит:
     * название дисциплины,
     * трудоемкость дисциплины в часах
     * оценку
     */
    private Collection<LineTable> table;

    public Reference(Student student, Data start, Data end, LineTable... table) {
        this.student = student;
        this.start = start;
        this.end = end;
        this.table = new ArrayList<>(List.of(table));
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Data getStart() {
        return start;
    }

    public void setStart(Data start) {
        this.start = start;
    }

    public Data getEnd() {
        return end;
    }

    public void setEnd(Data end) {
        this.end = end;
    }

    public Collection<LineTable> getTable() {
        return table;
    }

    public void setTable(Collection<LineTable> table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reference reference = (Reference) o;
        return Objects.equals(student, reference.student) && Objects.equals(start, reference.start) && Objects.equals(end, reference.end) && Objects.equals(table, reference.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, start, end, table);
    }
}