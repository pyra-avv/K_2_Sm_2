import java.util.*;
import java.util.function.Function;
import java.util.Comparator;
import java.lang.Comparable;

public class StreamApiDemo extends LambdaDemo {
    /**
     * 1) в списке объектов удалить все значения null
     */
    public static final Function<List<Object>, List<Object>> lambda11 = objectList ->
            objectList.stream().filter(Objects::nonNull).toList();
    /**
     * 2) во множестве целых чисел найти количество положительных значений
     */
    public static final Function<Set<Integer>, Integer> lambda12 = integerSet ->
            Math.toIntExact(integerSet.stream().filter(x -> x > 0).count());
    /**
     * 3) в списке объектов получить последние три элемента
     */
    public static final Function<List<Object>, List<Object>> lambda13 = objectList ->
            objectList.stream().skip(objectList.size() - 3).toList();
    /**
     * 4) всписке целых чисел получить первое чётное число или null, если в списке нет чётных чисел
     */
    public static final Function<List<Integer>, Integer> lambda14 = integers ->
            integers.stream().filter(x -> x % 2 == 0).findFirst().get();
    /**
     * 5) по массиву целых чисел построить список квадратов элементов массива без повторений
     */
    public static final Function<Integer[], List<Integer>> lambda15 = arr ->
            Arrays.stream(arr).map(x -> x * x).distinct().toList();
    /**
     * 6) по списку строк построить список, содержащий все непустые строки упорядоченные по возростанию
     */
    public static final Function<List<String>, List<String>> lambda16 = strings ->
            strings.stream().filter(s -> !s.equals("")).sorted().toList();
    /**
     * 7) множество строк превратить в список, упорядоченный по убыванию
     */
    public static final Function<Set<String>, List<String>> lambda17 = strings ->
            strings.stream().sorted(Comparator.reverseOrder()).toList();
    /**
     * 8) для множества целых чисел вычислить сумму квадратов его элементов
     */
    public static final Function<Set<Integer>, Integer> lambda18 = integerSet ->
            integerSet.stream().reduce(0, (k, x) -> k + x * x);
    /**
     * 9) В коллекции людей вычислить максимальный возраст человека
     */
    public static final Function<Collection<Human>, Integer> lambda19 = humanCollection ->
            humanCollection.stream().map(Human::getAge).reduce(0, (max, x) -> x > max ? x : max);
    /**
     * 10) отсортируйте коллекцию людей сначала по полу, потом по возрасту
     */
    public static final Function<Collection<Human>, Collection<Human>> lambda110 = humanCollection ->
            humanCollection.stream().sorted((o1, o2) -> {
                Character c1 = o1.getSex();
                Character c2 = o2.getSex();
                return c1.compareTo(c2);
            }).sorted((o1, o2) -> {
                Integer i1 = o1.getAge();
                return i1.compareTo(o2.getAge());
            }).toList();
}