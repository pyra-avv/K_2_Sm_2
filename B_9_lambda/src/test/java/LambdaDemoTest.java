import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {
    @Test
    void lambda1() {
        assertEquals(5, LambdaDemo.lambda1.StringIn("12345"));
        assertEquals(0, LambdaDemo.lambda1.StringIn(""));
        assertEquals(2, LambdaDemo.lambda1.StringIn("15"));
        assertEquals(7, LambdaDemo.lambda1.StringIn("1234523"));
    }
    @Test
    void lambda2() {
        assertEquals('1', LambdaDemo.lambda2.StringCh("12345"));
        assertEquals('3', LambdaDemo.lambda2.StringCh("345"));
        assertNull(LambdaDemo.lambda2.StringCh(""));
    }
    @Test
    void lambda3() {
        assertTrue(LambdaDemo.lambda3.StringBo("6544168"));
        assertFalse(LambdaDemo.lambda3.StringBo("65441 68"));
    }
    @Test
    void lambda4() {
        assertEquals(3, LambdaDemo.lambda4.StringIn("1, 234, 5"));
        assertEquals(1, LambdaDemo.lambda4.StringIn("345"));
    }
    @Test
    void lambda5() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals(5, LambdaDemo.lambda5.HumanIn(human1));
        assertEquals(17, LambdaDemo.lambda5.HumanIn(human2));
        assertEquals(17, LambdaDemo.lambda5.HumanIn(student1));
    }
    @Test
    void lambda6() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Human human3 = new Human("Петров", "Юрий", "Иваныч", 15, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertFalse(LambdaDemo.lambda6.Human2Bo(human1, human2));
        assertTrue(LambdaDemo.lambda6.Human2Bo(human3, human2));
        assertFalse(LambdaDemo.lambda6.Human2Bo(human1, student1));
        assertTrue(LambdaDemo.lambda6.Human2Bo(human3, student1));
    }
    @Test
    void lambda7() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals("Иванов Иван Иваныч", LambdaDemo.lambda7.HumanSt(human1));
        assertEquals("Петров Иван Иваныч", LambdaDemo.lambda7.HumanSt(human2));
        assertEquals("Петров Иван Иваныч", LambdaDemo.lambda7.HumanSt(student1));
    }
    @Test
    void lambda8() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertEquals(new Human("Иванов", "Иван", "Иваныч", 6, 'M'),
                LambdaDemo.lambda8.HumanHu(human1));
        assertEquals(new Human("Петров", "Иван", "Иваныч", 18, 'M'),
                LambdaDemo.lambda8.HumanHu(human2));
        assertEquals(new Human("Петров", "Иван", "Иваныч", 18, 'M'),
                LambdaDemo.lambda8.HumanHu(student1));
    }
    @Test
    void lambda9() {
        Human human1 = new Human("Иванов", "Иван", "Иваныч", 5, 'M');
        Human human2 = new Human("Петров", "Иван", "Иваныч", 17, 'M');
        Human human3 = new Human("Петров", "Юрий", "Иваныч", 15, 'M');
        Human human4 = new Human("Иванов", "Юрий", "Иваныч", 20, 'M');
        Student student1 = new Student("Петров", "Иван", "Иваныч", 17, 'M', "",
                "", "");
        assertFalse(LambdaDemo.lambda9.Human3IntBu(human1, human2, human4, 18));
        assertTrue(LambdaDemo.lambda9.Human3IntBu(human1, human2, human3, 18));
        assertFalse(LambdaDemo.lambda9.Human3IntBu(human1, student1, human4, 18));
        assertTrue(LambdaDemo.lambda9.Human3IntBu(human1, student1, human3, 18));
    }
    @Test
    void lambda11() {
        /**
         * я не могу создать список с элементом null
         */
//        List<Object> list1 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'),
//                null, "jn", "jjj", null, null,
//                new Student("", "","", 5,'М', "","", "")));
        List<Object> list2 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'), "jn",
                "jjj",  new Student("", "","", 5,'М', "","",
                        "")));
        //assertEquals(list2, LambdaDemo.lambda11.LObjectLOb(list1));
        assertEquals(list2, LambdaDemo.lambda11.LObjectLOb(list2));
    }
    @Test
    void lambda12() {
        Set<Integer> set1 = new HashSet<>(Set.of(25, -20, 0, 5, -3, 77));
        assertEquals(3, LambdaDemo.lambda12.SIntIn(set1));
    }
    @Test
    void lambda13() {
        List<Object> list1 = new ArrayList<>(of(new Human("", " ", "", 11, 'М'), "jn",
                "jjj",  new Student("", "","", 5,'М', "","",
                        ""), "44648", "411165"));
        List<Object> list2 = new ArrayList<>(of(new Student("", "","", 5,'М',
                "","",""), "44648", "411165"));
        assertEquals(list2, LambdaDemo.lambda13.LObjectLOb(list1));
    }
    @Test
    void lambda14() {
        List<Integer> list1 = new ArrayList<>(of(519, 51, -4, 541, 2));
        List<Integer> list2 = new ArrayList<>(of(519, 51, -5, 541, 1));
        assertEquals(-4, LambdaDemo.lambda14.LIntIn(list1));
        assertNull(LambdaDemo.lambda14.LIntIn(list2));
    }
    @Test
    void lambda15() {
        int[] arr1 = { 2, 6, 9, 2, 5 };
        List<Integer> list1 = new ArrayList<>(of(81, 4, 36, 25));
        assertEquals(list1, LambdaDemo.lambda15.AIntLIn(arr1));
    }
    @Test
    void lambda16() {
        List<String> list1 = new ArrayList<>(of("auibsiu", "", "22", "12", "ofd", "", "ikkmgpd"));
        List<String> list2 = new ArrayList<>(of("12", "22","auibsiu", "ikkmgpd", "ofd"));
        assertEquals(list2, LambdaDemo.lambda16.LStringLSt(list1));
    }
    @Test
    void lambda17() {
        Set<String> set1 = new HashSet<>(Set.of("auibsiu", "22", "12", "ofd", "ikkmgpd"));
        List<String> list1 = new ArrayList<>(of("ofd", "ikkmgpd", "auibsiu", "22", "12"));
        assertEquals(list1, LambdaDemo.lambda17.SStringLSt(set1));
    }
    @Test
    void lambda18() {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 6, 9, 5));
        assertEquals(146, LambdaDemo.lambda18.SIntIn(set1));
    }
    @Test
    void lambda19() {
        Collection<Human> collection1 = new ArrayList<>(of(new Human("Иванов", "Иван", "Иваныч", 5, 'M'),
                new Human("Петров", "Иван", "Иваныч", 17, 'M'),
                new Human("Петров", "Юрий", "Иваныч", 15, 'M'),
                new Human("Иванов", "Юрий", "Иваныч", 20, 'M')));
        assertEquals(20, LambdaDemo.lambda19.CHumanIn(collection1));
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
        LambdaDemo.lambda110.CHumanCHu(collection1);
        assertEquals(collection1, collection2);
    }
}
