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
            if (object instanceof Human) {
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

    /**
     * 3
     * @param o объект
     * @return список имен всех его суперклассов до класса Object включительно.
     */
    public static List<String> getSuperClasses(Object o) {
        ArrayList<String> res = new ArrayList<>();
        Class<?> oClass = o.getClass();
        do {
            oClass = oClass.getSuperclass();
            res.add(oClass.toString());
        } while (oClass != Object.class);
        return res;
    }

    /**
     * 4*
     * @param list список обЪектов
     * @return количество объектов из списка, которые реализуют интерфейс Executable и метод void execute()
     */
    public static int ImplementsAnExecutable(List<Object> list) {
        int res = 0;
        for (Object o : list) {
            boolean f1 = false, f2 = false;
            Class<?>[] oInter = o.getClass().getInterfaces();
            for (Class<?> inter : oInter) {
                if (inter == Executable.class) {
                    f1 = true;
                    break;
                }
            }
            List<String> oMethods = MethodList(o);
            for (String method : oMethods) {
                if (method.equals("public void " + o.getClass().toString().replace("class ", "") +
                        ".execute()")) {
                    f2 = true;
                    break;
                }
            }
            if (f1 && f2) {
                res++;
            }
        }
        return res;
    }






}
