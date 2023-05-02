import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.List.*;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @org.junit.jupiter.api.Test
    void howManyPeople() {
        List<Object> objectList = new ArrayList<>(of("ppppppp", new Human("", "", ""),
                new Human(".", ".", "."), "dvsv", "cast", new Student("", "",
                        "", "", "", "")));
        assertEquals(3, ReflectionDemo.HowManyPeople(objectList));
    }

    @org.junit.jupiter.api.Test
    void methodList() {
        List<String> list1 = new ArrayList<>(of("public java.lang.String Human.getName()",
                "public boolean Human.equals(java.lang.Object)", "public java.lang.String Human.toString()",
                "public int Human.hashCode()", "public void Human.setName(java.lang.String)",
                "public java.lang.String Human.getSurname()", "public java.lang.String Human.getPatronymic()",
                "public void Human.setSurname(java.lang.String)", "public void Human.setPatronymic(java.lang.String)",
                "public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException",
                "public final void java.lang.Object.wait() throws java.lang.InterruptedException",
                "public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException",
                "public final native java.lang.Class java.lang.Object.getClass()",
                "public final native void java.lang.Object.notify()",
                "public final native void java.lang.Object.notifyAll()",
                "public final java.lang.String Human.getStr()", "public final void Human.setStr(java.lang.String)"));
        List<String> list2 = ReflectionDemo.MethodList(new Human("", "", ""));
        Collections.sort(list1);
        Collections.sort(list2);
        assertEquals(list1, list2);
    }
    @org.junit.jupiter.api.Test
    void getSuperClasses() {
        List<String> list1 = new ArrayList<>(of("class java.lang.Object"));
        assertEquals(list1, ReflectionDemo.getSuperClasses(new Human("", "", "")));
        List<String> list2 = new ArrayList<>(of("class Human", "class java.lang.Object"));
        assertEquals(list2, ReflectionDemo.getSuperClasses(new Student("", "", "", "",
                "", "")));
    }

    @Test
    void implementsAnExecutable() {
        List<Object> objectList = new ArrayList<>(List.of("ppppppp", new Human("", "", ""),
                new Human(".", ".", "."), "dvsv", "cascva", new Student("", "",
                        "", "", "", ""), new ZZZ()));
        assertEquals(2, ReflectionDemo.ImplementsAnExecutable(objectList));
    }

    @Test
    void getSetAndGet() {
        List<String> list1 = new ArrayList<>(of("public java.lang.String Human.getName()",
                "public void Human.setName(java.lang.String)", "public java.lang.String Human.getSurname()",
                "public java.lang.String Human.getPatronymic()", "public void Human.setSurname(java.lang.String)",
                "public void Human.setPatronymic(java.lang.String)", "public final void Human.setStr(java.lang.String)",
                "public final java.lang.String Human.getStr()"));
        List<String> list2 = ReflectionDemo.getSetAndGet(new Human("", "", ""));
        Collections.sort(list1);
        Collections.sort(list2);
        assertEquals(list1, list2);
    }

    static class ZZZ extends Student {
        public ZZZ() {
            super("surname", "name", "patronymic", "faculty", "university",
                    "speciality");
        }
    }
}