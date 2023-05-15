import java.util.*;
import java.util.Collections;

public class LambdaDemo {
    /**
     * 1) для строки символов получить ее длину
     */
    public static final Lambda1 lambda1 = str -> str.length();
    /**
     * 2) для строки символов получить ее первый символ, если он существует, или null иначе
     */
    public static final Lambda2 lambda2 = str -> {
      if (str.equals("")) {
          return null;
      }
      return str.charAt(0);
    };
    /**
     * 3) для строки проверить, что она не содержит пробелов
     */
    public static final Lambda3 lambda3 = str -> {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    };
    /**
     * 4) слова в строке разделены запятыми, по строке получить количество слов в ней
     */
    public static final Lambda1 lambda4 = str -> {
        int k = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                k++;
            }
        }
        return k;
    };
    /**
     * 5) по человеку получить его возраст
     */
    public static final Lambda4 lambda5 = human -> human.getAge();
    /**
     * 6) по двум людям проверить, что у них одинаковая фамилия
     */
    public static final Lambda5 lambda6 = (human1, human2) -> human1.getSurname().equals(human2.getSurname());
    /**
     * 7) получить фамилию, имя и отчество человека в виде одной строки (разделитель пробел)
     */
    public static final Lambda6 lambda7 = human -> human.getSurname() + " " + human.getName() + " " +
            human.getPatronymic();
    /**
     * 8) сделать человека старше на один год (по объекту Human создать новый объект)
     */
    public static final Lambda7 lambda8 = human -> new Human(human.getSurname(), human.getName(), human.getPatronymic(),
            human.getAge() + 1, human.getSex());
    /**
     * 9) по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
     */
    public static final Lambda8 lambda9 = (human1, human2, human3, maxAge) -> human1.getAge() < maxAge &&
            human2.getAge() < maxAge && human3.getAge() < maxAge;
    /**
     * 1) в списке объектов удалить все значения null
     */
    public static final Lambda9 lambda11 = objectList -> {
        List<Object> res = new ArrayList<>();
        for (Object o : objectList) {
            if (o != null) {
                res.add(o);
            }
        }
        return res;
    };
    /**
     * 2) во множестве целых чисел найти количество положительных значений
     */
    public static final Lambda10 lambda12 = integerSet -> {
        int k = 0;
        for (Integer x : integerSet) {
            if (x > 0) {
                k++;
            }
        }
        return k;
    };
    /**
     * 3) в списке объектов получить последние три элемента
     */
    public static final Lambda9 lambda13 = objectList -> {
        List<Object> res = new ArrayList<>();
        for (int i = objectList.size() - 3; i < objectList.size(); i++) {
            res.add(objectList.get(i));
        }
        return res;
    };
    /**
     * 4) всписке целых чисел получить первое чётное число или null, если в списке нет чётных чисел
     */
    public static final Lambda11 lambda14 = integers -> {
        for (Integer x : integers) {
            if (x % 2 == 0) {
                return x;
            }
        }
        return null;
    };
    /**
     * 5) по массиву целых чисел построить список квадратов элементов массива без повторений
     */
    public static final Lambda12 lambda15 = arr -> {
        Set<Integer> integerSet = new HashSet<>();
        for (int x : arr) {
            integerSet.add(x * x);
        }
        return new ArrayList<>(integerSet);
    };
    /**
     * 6) по списку строк построить список, содержащий все непустые строки упорядоченные по возростанию
     */
    public static final Lambda13 lambda16 = strings -> {
        List<String> res = new ArrayList<>();
        for (String str : strings) {
            if (!str.equals("")) {
                res.add(str);
            }
        }
        Collections.sort(res);
        return res;
    };
    /**
     * 7) множество строк превратить в список, упорядоченный по убыванию
     */
    public static final Lambda14 lambda17 = strings -> {
        List<String> res = new ArrayList<>(strings);
        res.sort(Collections.reverseOrder());
        return res;
    };
    /**
     * 8) для множества целых чисел вычислить сумму квадратов его элементов
     */
    public static final Lambda10 lambda18 = integerSet -> {
        int k = 0;
        for (Integer x : integerSet) {
            k += x * x;
        }
        return k;
    };
    /**
     * 9) В коллекции людей вычислить максимальный возраст человека
     */
    public static final Lambda15 lambda19 = humanCollection -> {
        int k = 0;
        for (Human human : humanCollection) {
            if (human.getAge() > k) {
                k = human.getAge();
            }
        }
        return k;
    };
    /**
     * 10) отсортируйте коллекцию людей сначала по полу, потом по возрасту
     */
    public static final Lambda16 lambda110 = humanCollection -> {
        TreeMap<Integer, Human> mapW = new TreeMap<>();
        TreeMap<Integer, Human> mapM = new TreeMap<>();
        for (Human human : humanCollection) {
            if (human.getSex() == 'Ж') {
                mapW.put(human.getAge(), human);
            } else {
                mapM.put(human.getAge(), human);
            }
        }
        humanCollection.clear();
        humanCollection.addAll(mapW.values());
        humanCollection.addAll(mapM.values());
        return humanCollection;
    };
}

interface Lambda1 {
    int StringIn(String str);
}

interface Lambda2 {
    Character StringCh(String str);
}

interface Lambda3 {
    boolean StringBo(String str);
}

interface Lambda4 {
    int HumanIn(Human human);
}

interface Lambda5 {
    boolean Human2Bo(Human human1, Human human2);
}

interface Lambda6 {
    String HumanSt(Human human);
}

interface Lambda7 {
    Human HumanHu(Human human);
}

interface Lambda8 {
    boolean Human3IntBu(Human human1, Human human2, Human human3, int maxAge);
}

interface Lambda9 {
    List<Object> LObjectLOb(List<Object> objectList);

}

interface Lambda10 {
    int SIntIn(Set<Integer> integerSet);
}

interface Lambda11 {
    Integer LIntIn(List<Integer> integers);
}

interface Lambda12 {
    List<Integer> AIntLIn(int[] arr);
}

interface Lambda13 {
    List<String> LStringLSt(List<String> strings);
}

interface Lambda14 {
    List<String> SStringLSt(Set<String> strings);
}

interface Lambda15 {
    int CHumanIn(Collection<Human> humanCollection);
}

interface Lambda16 {
    Collection<Human> CHumanCHu(Collection<Human> humanCollection);
}