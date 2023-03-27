import java.util.Objects;

public class LineTable {
    private final String Discipline;
    private final int LaborIntensity;
    private final Grade Grade;

    public LineTable(String Discipline, int LaborIntensity, int Grade) {
        this.Grade = new Grade(Grade);
        this.LaborIntensity = LaborIntensity;
        this.Discipline = Discipline;
    }

    public Grade getGrade() {
        return Grade;
    }

    public int getLaborIntensity() {
        return LaborIntensity;
    }

    public String getDiscipline() {
        return Discipline;
    }

    @Override
    public String toString() {
        return "Название дисциплины: " + Discipline + "; кол_во часов: " + LaborIntensity + "; оценка: " + Grade + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineTable lineTable = (LineTable) o;
        return LaborIntensity == lineTable.LaborIntensity && Grade == lineTable.Grade && Objects.equals(Discipline, lineTable.Discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Discipline, LaborIntensity, Grade);
    }
}
