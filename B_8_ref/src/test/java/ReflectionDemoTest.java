import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @org.junit.jupiter.api.Test
    void howManyPeople() {
        List<Object> objectList = new ArrayList<>(List.of("ppppppp", new Human("", "", ""),
                new Human(".", ".", "."), "dvsv", "cascva"));
        assertEquals(2, ReflectionDemo.HowManyPeople(objectList));
    }

    @org.junit.jupiter.api.Test
    void methodList() {
    }
}