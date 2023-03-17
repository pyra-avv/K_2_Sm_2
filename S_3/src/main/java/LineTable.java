import java.util.Objects;

public class LineTable {
    private String Discipline;
    private int LaborIntensity;
    private Grade Grade;

    public LineTable(String Discipline, int LaborIntensity, int Grade) {
        this.Grade = new Grade(Grade);
        this.LaborIntensity = LaborIntensity;
        this.Discipline = Discipline;
    }

    public Grade getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        this.Grade = new Grade(grade);
    }

    public int getLaborIntensity() {
        return LaborIntensity;
    }

    public void setLaborIntensity(int laborIntensity) {
        LaborIntensity = laborIntensity;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
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
