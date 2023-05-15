import org.junit.jupiter.api.Test;

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
}
