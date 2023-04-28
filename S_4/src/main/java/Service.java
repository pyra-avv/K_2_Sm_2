import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public Service() {
    }
    /**
     * 1
     * @param Persons список объектов Person
     * @return список строк. Строка должна содержать имя человека,
     * но для студентов после имени должно быть написано (студент группы название_группы)
     */
    public static List<String> getNames(List<Person> Persons) {
        List<String> res = new ArrayList<>();
        for (Person person : Persons) {
            if (person instanceof Student) {
                res.add(person.getName() + " студент группы " + ((Student) person).getGroupName());
            } else {
                res.add(person.getName());
            }
        }
        return res;
    }

    /**
     * 2
     * @param objects список элементов типа Object
     * @return объекты, которые можно сериализовать встроенными средствами Java
     */
    public static List<Object> getObjectsSer(List<Object> objects) {
        List<Object> res = new ArrayList<>();
        for (Object object : objects) {
            List<Class<?>> interfaces = new ArrayList<>(List.of(object.getClass().getInterfaces()));
            for (Class<?> interface_ : interfaces) {
                if(interface_.equals(Serializable.class)) {
                    res.add(object);
                }
            }

        }
        return res;
    }

    /**
     * 3
     * @param object объект
     * @return true, если но не содержит static методов
     */
    public static boolean NotStatic(Object object) {
        Class<?> clz = object.getClass();
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            if (method.toString().contains("static")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 4
     * @param object произвольный объект
     * @return проверка, что объект реализует какой-то функциональный интерфейс.
     */
    public static boolean IsThereAnInterface(Object object) {
        List<Class<?>> interfaces = new ArrayList<>(List.of(object.getClass().getInterfaces()));
        return interfaces.size() != 0;
    }

    /**
     * 5
     * @param classes список объектов класса Class
     * @return список оъектов, созданных конструктором по умолчанию
     */
    public static List<Object> ConstructorDef(List<Class<?>> classes) throws InvocationTargetException,
            InstantiationException, IllegalAccessException {
        List<Object> res = new ArrayList<>();
        for (Class<?> clazz : classes) {
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.toString().endsWith("()")) {
                    res.add(constructor.newInstance());
                }
            }
        }
        return res;
    }

    /**
     * 6
     * @param className название класса
     * @return объект класса "className"
     * (пусть объект создаётся конструктором по умолчанию, если такового нет, возвращается null)
     */
    public static Object ObjectClassName(String className) throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.toString().endsWith("()")) {
                return constructor.newInstance();
            }
        }
        return null;
    }
}
