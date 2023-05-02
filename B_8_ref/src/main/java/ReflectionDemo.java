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
            if (Executable.class.isAssignableFrom(o.getClass())) {
                ((Executable) o).execute();
                res++;
            }
        }
        return res;
    }

    /**
     * 5*
     * @param o объект
     * @return список его геттеров и сеттеров
     */
    public static List<String> getSetAndGet(Object o) {
        List<String> res = new ArrayList<>();
        for (String method : MethodList(o)) {
            String[] wordsMethod = method.split(" ");
            boolean publicFlag = false, notStaticFlag = true, setAndGetFlag = false;
            for (int i = 0; i < wordsMethod.length - 1; i++) {
                if (wordsMethod[i].equals("public")) {
                    publicFlag = true;
                }
                if (wordsMethod[i].equals("static")) {
                    notStaticFlag = false;
                    break;
                }
                if (wordsMethod[i].equals("void")) {
                    if (wordsMethod[i + 1].startsWith(o.getClass().toString().replace("class ", "") +
                            ".set") && !wordsMethod[i + 1].endsWith("()")) {
                        setAndGetFlag = true;
                    }
                } else {
                    if (wordsMethod[i + 1].startsWith(o.getClass().toString().replace("class ", "") +
                            ".get") && wordsMethod[i + 1].endsWith("()")) {
                        setAndGetFlag = true;
                    }
                }

            }
            if (publicFlag && notStaticFlag && setAndGetFlag) {
                res.add(method);
            }
        }
        return res;
    }
}
