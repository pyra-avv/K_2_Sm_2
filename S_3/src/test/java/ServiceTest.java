import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class ServiceTest {

    @Test
    void listDisciplines() {
        Collection<String> ret1 = new ArrayList<>(List.of("МатАн", "АлГем", "Физ-ра", "Графы", "БЖД"));
        Collection<String> ret2 = new ArrayList<>(List.of("ОП", "ПсиАн", "Физ-ра", "ИсторияП", "БЖД"));
        Assertions.assertEquals(ret1, Service.ListDisciplines(reference1()));
        Assertions.assertEquals(ret2, Service.ListDisciplines(reference2()));
    }

    @org.junit.jupiter.api.Test
    void generalLaborIntensity() {
        Assertions.assertEquals(68, Service.GeneralLaborIntensity(reference1()));
        Assertions.assertEquals(85, Service.GeneralLaborIntensity(reference2()));
    }

    @org.junit.jupiter.api.Test
    void averageScore() {
        Assertions.assertEquals(4, Service.AverageScore(reference1()));
        Assertions.assertEquals(4.1, Service.AverageScore(reference2()), 0.2);
    }

    @org.junit.jupiter.api.Test
    void disciplineGrade() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("МатАн", "Удовлетворительно");
        map1.put("АлГем", "Неудовлетворительно");
        map1.put("Физ-ра", "Зачтено");
        map1.put("Графы", "Хорошо");
        map1.put("БЖД", "Отлично");
        Assertions.assertEquals(map1, Service.DisciplineGrade(reference1()));
        Map<String, String> map2 = new HashMap<>();
        map2.put("ОП", "Хорошо");
        map2.put("ПсиАн", "Хорошо");
        map2.put("Физ-ра", "Зачтено");
        map2.put("ИсторияП", "Хорошо");
        map2.put("БЖД", "Отлично");
        Assertions.assertEquals(map2, Service.DisciplineGrade(reference2()));
    }

    @org.junit.jupiter.api.Test
    void gradeDiscipline() {
        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("Удовлетворительно", new ArrayList<>(List.of("МатАн")));
        map1.put("Неудовлетворительно", new ArrayList<>(List.of("АлГем")));
        map1.put("Зачтено", new ArrayList<>(List.of("Физ-ра")));
        map1.put("Хорошо", new ArrayList<>(List.of("Графы")));
        map1.put("Отлично", new ArrayList<>(List.of("БЖД")));
        Assertions.assertEquals(map1, Service.GradeDiscipline(reference1()));
        Map<String, List<String>> map2 = new HashMap<>();
        map2.put("Хорошо", new ArrayList<>(List.of("ОП", "ПсиАн", "ИсторияП")));
        map2.put("Зачтено", new ArrayList<>(List.of("Физ-ра")));
        map2.put("Отлично", new ArrayList<>(List.of("БЖД")));
        Assertions.assertEquals(map2, Service.GradeDiscipline(reference2()));
    }

    Reference reference1() {
        return new Reference(new Student("Щербаков", "Юрий", "Александрович",
                "ИМИТ", "ОмГУ", "ПМиИ"),  
                new Data(1, 9, 2020), new Data(1, 8, 2024),
                new LineTable("МатАн", 10, 3), 
                new LineTable("АлГем", 10, 2),
                new LineTable("Физ-ра", 15, 1),
                new LineTable("Графы", 20, 4),
                new LineTable("БЖД", 13, 5));
    }
    Reference reference2() {
        return new Reference(new Student("Иванов", "Иван", "Иваныч",
                "ПсихФак", "ОмГПУ", "ПМвмфыв"),
                new Data(1, 9, 2021), new Data(1, 8, 2026),
                new LineTable("ОП", 20, 4),
                new LineTable("ПсиАн", 15, 4),
                new LineTable("Физ-ра", 15, 1),
                new LineTable("ИсторияП", 25, 4),
                new LineTable("БЖД", 10, 5));
    }
}