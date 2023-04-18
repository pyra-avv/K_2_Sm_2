import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
    /**
     * 1
     * @param objectList список объектов произвольных типов
     * @return количество элементов списка, которые являются объектами типа Human или его подтипами.
     */
    public static int HowManyPeople(List<Object> objectList) {
        int res = 0;
        for (Object object : objectList) {
            if (object.getClass() == Human.class) {
                res++;
            }
        }
        return res;
    }

    /**
     * 2
     * @param o объект
     * @return список имен его открытых методов
     */
    public static List<String> MethodList(Object o) {
        Class<?> clz = o.getClass();
        Method[] methods = clz.getMethods();
        ArrayList<String> res = new ArrayList<>();
        for (Method method : methods) {
            res.add(method.toString());
        }
        return res;
    }







}
