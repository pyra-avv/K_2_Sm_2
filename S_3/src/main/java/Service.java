import java.util.*;

public class Service {

    /**
     * 3.1
     * @param reference справка
     * @return список названий изученных дисциплин.
     */
    public static Collection<String> ListDisciplines(Reference reference) {
        Collection<String> res = new ArrayList<>();
        for (LineTable line : reference.getTable()) {
            res.add(line.getDiscipline());
        }
        return res;
    }

    /**
     * 3.2
     * @param reference справка
     * @return сумма часов по всем дисциплинам
     */
    public static int GeneralLaborIntensity(Reference reference) {
        int res = 0;
        for (LineTable line : reference.getTable()) {
            res += line.getLaborIntensity();
        }
        return res;
    }

    /**
     * 3.3
     * @param reference справка
     * @return средний балл оценок
     */
    public static int AverageScore(Reference reference) {
        int res = 0;
        int k = 0;
        for (LineTable line : reference.getTable()) {
            if (line.getGrade().getGrade() > 2) {
                res += line.getGrade().getGrade();
                k++;
            }
        }
        return res / k;
    }

    /**
     * 3.4
     * @param reference справка
     * @return отображение названий дисциплин в оценки
     */
    public static Map<String, String> DisciplineGrade(Reference reference) {
        Map<String, String> res = new HashMap<>();
        for (LineTable line : reference.getTable()) {
            res.put(line.getDiscipline(), line.getGrade().toString());
        }
        return res;
    }

    /**
     * 3.5
     * @param reference справка
     * @return отображение оценки в список дисциплин, которые сданы на эту оценку
     */
    public static Map<String, List<String>> GradeDiscipline(Reference reference) {
        Map<String, List<String>> res = new HashMap<>();
        for (LineTable line : reference.getTable()) {
            if (res.containsKey(line.getGrade().toString())) {
                res.get(line.getGrade().toString()).add(line.getDiscipline());
            } else {
                res.put(line.getGrade().toString(), new ArrayList<>(List.of(line.getDiscipline())));
            }
        }
        return res;
    }
}
