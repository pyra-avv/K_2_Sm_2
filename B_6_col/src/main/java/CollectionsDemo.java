import com.sun.tools.sjavac.Util;

import java.util.*;

import static com.sun.tools.sjavac.Util.intersection;


public class CollectionsDemo {
    /*
    Вход: список строк и символ. Выход: количество строк входного списка, у которых первый
    символ совпадает с заданным.
    */
    public static int FirstSymbol(Collection<String> arrStr, char s) {
        int res = 0;
        for (String str : arrStr) {
            if (!str.equals("") && s == str.charAt(0)) {
                res++;
            }
        }
        return res;
    }
    /*
    Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    и еще один объект типа Human. Результат — список однофамильцев заданного человека
    среди людей из входного списка.
    */
    public static List<Human> SameSurnames(List<Human> listHuman, Human one) {
        List<Human> listRes = new ArrayList<>();
        for (Human human : listHuman) {
            if (human.getSurname().equals(one.getSurname())) {
                listRes.add(human);
            }
        }
        return listRes;
    }
    /*
    Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
    входного списка, не содержащая выделенного человека. При изменении элементов
    входного списка элементы выходного изменяться не должны.
     */
    public static List<Human> ListWithoutOne(List<Human> listHuman, Human one) {
        List<Human> res = new ArrayList<>();
        for (Human human : listHuman) {
           if (!human.equals(one)) {
               res.add(human);
           }
        }
        return res;
    }
    /*
    Вход: список множеств целых чисел и еще одно множество. Выход: список всех множеств
    входного списка, которые не пересекаются с заданным множеством.
    */
    public static List<Set<Integer>> NotIntersect(List<Set<Integer>> listSet, Set<Integer> set) {
        List<Set<Integer>> res = new ArrayList<>();
        for (Set<Integer> setInt : listSet) {
            Set<Integer> intersection = new HashSet<>(setInt);
            intersection.removeAll(set);
            if (intersection.equals(setInt)) {
                res.add(setInt);
            }
        }
        return res;
    }
    /*
    Напишите метод класса ListDemo, который получает на вход список, состоящий из
    объектов типа Human и его производных классов. Результат — множество людей из
    входного списка с максимальным возрастом.
    */
    public static Set<Human> MaxAge(List<Human> list) {
        int max = 0;
        Set<Human> res = new HashSet<>();
        for (Human human : list) {
            if (human.getAge() > max) {
                max = human.getAge();
                res.clear();
            }
            if (human.getAge() == max) {
                res.add(human);
            }
        }
        return res;
    }

    /*
    Напишите метод, который получает на вход отображение (Map)
    целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    Результат — множество людей, идентификаторы которых содержатся во входном
    множестве.
    */
    public static Set<Human> Display(Map<Integer, Human> map, Set<Integer> setInt) {
        Set<Human> res = new HashSet<>();
        for (Integer k : setInt) {
            if (map.containsKey(k)) {
                res.add(map.get(k));
            }
        }
        return res;
    }
    /*
    Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не
    менее 18 лет.
    */
    public static List<Integer> ListOfAdults(Map<Integer, Human> map) {
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Human> m : map.entrySet()) {
            if (m.getValue().getAge() > 18) {
                res.add(m.getKey());
            }
        }
        return res;
    }
    /*
    Для отображения из задачи 7 постройте новое отображение, которое идентификатору
    сопоставляет возраст человека.
    */
    public static Map<Integer, Integer> toAge(Map<Integer, Human> map) {
        Map<Integer, Integer> res = new HashMap<>();
        for (Map.Entry<Integer, Human> m : map.entrySet()) {
           res.put(m.getKey(), m.getValue().getAge());
        }
        return res;
    }
    /*
    По множеству объектов типа Human постройте отображение, которое целому числу
    (возраст человека) сопоставляет список всех людей данного возраста из входного
    множества.
    */
    public static Map<Integer, List<Human>> NewMap(Set<Human> setHuman) {
        Map<Integer, List<Human>> res = new HashMap<>();
        for (Human human : setHuman) {
            if (res.containsKey(human.getAge())) {
                res.get(human.getAge()).add(human);
            } else {
                res.put(human.getAge(), new ArrayList<>(List.of(human)));
            }
        }
        return res;
    }
}
