import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @org.junit.jupiter.api.Test
    void getNames() {
        List<Person> Persons1 = new ArrayList<>(List.of(new Person("Петя"), new Student("Юра", "ММБ"),
                new Student("Вася", "МММ"), new Person("Лера")));
        List<String> res1 = new ArrayList<>(List.of("Петя", "Юра студент группы ММБ",
                "Вася студент группы МММ", "Лера"));
        assertEquals(res1, Service.getNames(Persons1));
    }

    @org.junit.jupiter.api.Test
    void getObjectsSer() {
        List<Object> objects1 = new ArrayList<>(List.of(new Person("Петя"), "AAA",
                new Student("Вася", "МММ"),  new Person("Лера")));
        List<Object> res1 = new ArrayList<>(List.of("AAA", new Student("Вася", "МММ")));
        assertEquals(res1, Service.getObjectsSer(objects1));
    }

    @org.junit.jupiter.api.Test
    void notStatic() {
        Student student1 = new Student("Вася", "МММ");
        Service service1 = new Service();
        assertFalse(Service.NotStatic(service1));
        assertTrue(Service.NotStatic(student1));
    }

    @org.junit.jupiter.api.Test
    void isThereAnInterface() {
        Student student1 = new Student("Вася", "МММ");
        Service service1 = new Service();
        assertFalse(Service.IsThereAnInterface(service1));
        assertTrue(Service.IsThereAnInterface(student1));
    }
}