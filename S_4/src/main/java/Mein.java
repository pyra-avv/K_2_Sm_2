import java.lang.reflect.Method;

public class Mein {
    public static void main(String[] args) {
        Class<?> clz = Student.class;
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.print(method.toString() + "\n");
        }

    }

}
