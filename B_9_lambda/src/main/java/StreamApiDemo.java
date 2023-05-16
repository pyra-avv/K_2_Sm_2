import java.util.*;
import java.util.function.Function;

public class StreamApiDemo extends LambdaDemo {
    /**
     * 1) в списке объектов удалить все значения null
     */
    public static final Function<List<Object>, List<Object>> lambda11 = objectList ->
            objectList.stream().filter(Objects::nonNull).toList();
    /**
     * 2) во множестве целых чисел найти количество положительных значений
     */
    public static final Function<Set<Integer>, Integer> lambda12 = integerSet -> {
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
    public static final Function<List<Object>, List<Object>> lambda13 = objectList -> {
        List<Object> res = new ArrayList<>();
        for (int i = objectList.size() - 3; i < objectList.size(); i++) {
            res.add(objectList.get(i));
        }
        return res;
    };
    /**
     * 4) всписке целых чисел получить первое чётное число или null, если в списке нет чётных чисел
     */
    public static final Function<List<Integer>, Integer> lambda14 = integers -> {
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
    public static final Function<Integer[], List<Integer>> lambda15 = arr -> {
        Set<Integer> integerSet = new HashSet<>();
        for (int x : arr) {
            integerSet.add(x * x);
        }
        return new ArrayList<>(integerSet);
    };
    /**
     * 6) по списку строк построить список, содержащий все непустые строки упорядоченные по возростанию
     */
    public static final Function<List<String>, List<String>> lambda16 = strings -> {
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
    public static final Function<Set<String>, List<String>> lambda17 = strings -> {
        List<String> res = new ArrayList<>(strings);
        res.sort(Collections.reverseOrder());
        return res;
    };
    /**
     * 8) для множества целых чисел вычислить сумму квадратов его элементов
     */
    public static final Function<Set<Integer>, Integer> lambda18 = integerSet -> {
        int k = 0;
        for (Integer x : integerSet) {
            k += x * x;
        }
        return k;
    };
    /**
     * 9) В коллекции людей вычислить максимальный возраст человека
     */
    public static final Function<Collection<Human>, Integer> lambda19 = humanCollection -> {
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
    public static final Function<Collection<Human>, Collection<Human>> lambda110 = humanCollection -> {
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
