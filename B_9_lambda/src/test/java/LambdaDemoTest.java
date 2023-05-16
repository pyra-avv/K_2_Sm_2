import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {
    @Test
    void lambda1() {
        assertEquals(5, LambdaRunner.LambdaF1(LambdaDemo.lambda1, "12345"));
        assertEquals(0, LambdaRunner.LambdaF1(LambdaDemo.lambda1, ""));
        assertEquals(2, LambdaRunner.LambdaF1(LambdaDemo.lambda1, "15"));
        assertEquals(7, LambdaRunner.LambdaF1(LambdaDemo.lambda1, "1234523"));
    }
    @Test
    void lambda2() {
        assertEquals('1', LambdaRunner.LambdaF1(LambdaDemo.lambda2, "12345"));
        assertEquals('3',LambdaRunner.LambdaF1(LambdaDemo.lambda2, "345"));
        assertNull(LambdaRunner.LambdaF1(LambdaDemo.lambda2, ""));
        assertNull(LambdaRunner.LambdaF1(LambdaDemo.lambda2, null));
    }
    @Test
    void lambda3() {
        assertTrue(LambdaRunner.LambdaF1(LambdaDemo.lambda3, "6544168"));
        assertFalse(LambdaRunner.LambdaF1(LambdaDemo.lambda3,"65441 68"));
    }
    @Test
    void lambda4() {
        assertEquals(3,LambdaRunner.LambdaF1(LambdaDemo.lambda4, "1,,,234, 5"));
        assertEquals(1, LambdaRunner.LambdaF1(LambdaDemo.lambda4, "345"));
    }
    @Test
    void lambda5() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals(5, LambdaRunner.LambdaF1(LambdaDemo.lambda5, human1));
        assertEquals(17, LambdaRunner.LambdaF1(LambdaDemo.lambda5, human2));
        assertEquals(17, LambdaRunner.LambdaF1(LambdaDemo.lambda5, student1));
    }
    @Test
    void lambda6() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Human human3 = new Human("Петров", "Юрий", "Иваныч", 15, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertFalse(LambdaRunner.LambdaF2(LambdaDemo.lambda6, human1, human2));
        assertTrue(LambdaRunner.LambdaF2(LambdaDemo.lambda6, human3, human2));
        assertFalse(LambdaRunner.LambdaF2(LambdaDemo.lambda6, human1, student1));
        assertTrue(LambdaRunner.LambdaF2(LambdaDemo.lambda6, human3, student1));
    }
    @Test
    void lambda7() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals("Иванов Иван Иваныч", LambdaRunner.LambdaF1(LambdaDemo.lambda7, human1));
        assertEquals("Петров Иван Иваныч", LambdaRunner.LambdaF1(LambdaDemo.lambda7, human2));
        assertEquals("Петров Иван Иваныч", LambdaRunner.LambdaF1(LambdaDemo.lambda7, student1));
    }
    @Test
    void lambda8() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals(new Human("Иванов", "Иван", "Иваныч", 6, 'M'),
                LambdaRunner.LambdaF1(LambdaDemo.lambda8, human1));
        assertEquals(new Human("Петров", "Иван", "Иваныч", 18, 'M'),
                LambdaRunner.LambdaF1(LambdaDemo.lambda8, human2));
        assertEquals(new Human("Петров", "Иван", "Иваныч", 18, 'M'),
                LambdaRunner.LambdaF1(LambdaDemo.lambda8, student1));
    }
    @Test
    void lambda9() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Human human3 = new Human("Петров", "Юрий", "Иваныч", 15, 'M');
        Human human4 = new Human("Иванов", "Юрий", "Иваныч", 20, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertFalse(LambdaRunner.LambdaF4(LambdaDemo.lambda9, human1, human2, human4, 18));
        assertTrue(LambdaRunner.LambdaF4(LambdaDemo.lambda9, human1, human2, human3, 18));
        assertFalse(LambdaRunner.LambdaF4(LambdaDemo.lambda9, human1, student1, human4, 18));
        assertTrue(LambdaRunner.LambdaF4(LambdaDemo.lambda9, human1, student1, human3, 18));
    }
    @Test
    void lambda11() {
        List<Object> list1 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'), "jn",
                "jjj", new Student("", "","", 5,'М', "","", "")));
        list1.add(null);
        List<Object> list2 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'), "jn",
                "jjj",  new Student("", "","", 5,'М', "","",
                        "")));
        assertEquals(list2, LambdaRunner.LambdaF1(StreamApiDemo.lambda11, list1));
        assertEquals(list2, LambdaRunner.LambdaF1(StreamApiDemo.lambda11, list2));
    }
    @Test
    void lambda12() {
        Set<Integer> set1 = new HashSet<>(Set.of(25, -20, 0, 5, -3, 77));
        assertEquals(3, LambdaRunner.LambdaF1(StreamApiDemo.lambda12, set1));
    }
    @Test
    void lambda13() {
        List<Object> list1 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'), "jn",
                "jjj",  new Student("", "","", 5,'М', "","",
                        ""), "44648", "411165"));
        List<Object> list2 = new ArrayList<>(of(new Student("", "","", 5,'М',
                "","",""), "44648", "411165"));
        assertEquals(list2, LambdaRunner.LambdaF1(StreamApiDemo.lambda13, list1));
    }
    @Test
    void lambda14() {
        List<Integer> list1 = new ArrayList<>(of(519, 51, -4, 541, 2));
        List<Integer> list2 = new ArrayList<>(of(519, 51, -5, 541, 1));
        assertEquals(-4, LambdaRunner.LambdaF1(StreamApiDemo.lambda14, list1));
        assertNull(LambdaRunner.LambdaF1(StreamApiDemo.lambda14, list2));
    }
    @Test
    void lambda15() {
        Integer[] arr1 = { 2, 6, 9, 2, 5 };
        assertEquals(new ArrayList<>(of(4, 36, 81, 25)), LambdaRunner.LambdaF1(StreamApiDemo.lambda15, arr1));
    }
    @Test
    void lambda16() {
        List<String> list1 = new ArrayList<>(of("auibsiu", "", "22", "12", "ofd", "", "ikkmgpd"));
        assertEquals(new ArrayList<>(of("12", "22","auibsiu", "ikkmgpd", "ofd")),
                LambdaRunner.LambdaF1(StreamApiDemo.lambda16, list1));
    }
    @Test
    void lambda17() {
        Set<String> set1 = new HashSet<>(Set.of("auibsiu", "22", "12", "ofd", "ikkmgpd"));
        assertEquals(new ArrayList<>(of("ofd", "ikkmgpd", "auibsiu", "22", "12")),
                LambdaRunner.LambdaF1(StreamApiDemo.lambda17, set1));
    }
    @Test
    void lambda18() {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 6, 9, 5));
        assertEquals(146, LambdaRunner.LambdaF1(StreamApiDemo.lambda18, set1));
    }
    @Test
    void lambda19() {
        Collection<Human> collection1 = new ArrayList<>(of(new Human("Иванов", "Иван", "Иваныч", 5, 'M'),
                new Human("Петров", "Иван", "Иваныч", 17, 'M'),
                new Human("Петров", "Юрий", "Иваныч", 15, 'M'),
                new Human("Иванов", "Юрий", "Иваныч", 20, 'M')));
        assertEquals(20, LambdaRunner.LambdaF1(StreamApiDemo.lambda19, collection1));
    }
    @Test
    void lambda110() {
        Collection<Human> collection1 = new ArrayList<>(of(new Human("Иванов", "Иван", "Иваныч", 5, 'M'),
                new Human("Петров", "Иван", "Иваныч", 17, 'Ж'),
                new Human("Петров", "Юрий", "Иваныч", 4, 'M'),
                new Human("Иванов", "Юрий", "Иваныч", 2, 'Ж')));
        Collection<Human> collection2 = new ArrayList<>(of(
                new Human("Иванов", "Юрий", "Иваныч", 2, 'Ж'),
                new Human("Петров", "Иван", "Иваныч", 17, 'Ж'),
                new Human("Петров", "Юрий", "Иваныч", 4, 'M'),
                new Human("Иванов", "Иван", "Иваныч", 5, 'M')));
        LambdaRunner.LambdaF1(StreamApiDemo.lambda110, collection1);
        assertEquals(collection1, collection2);
    }
}
