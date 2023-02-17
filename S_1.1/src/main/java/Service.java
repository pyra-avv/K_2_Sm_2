import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class Service {
    /*
     По списку элементов типа Data и строке name отобрать те элементы списка, имена
     которых равны name. Результат вернуть в виде коллекции.
     */
    public static Collection<Data> Selection1(ArrayList<Data> arr, String name) {
        Collection<Data> col = new ArrayList<>();
        for (Data data : arr) {
            if (data.getName().equals(name)) {
                col.add(data);
            }
        }
        return col;
    }
    /*
     По списку элементов типа Data и вещ. числу level отобрать и вернуть в виде коллекции
     те элементы списка, у которых |value| <= level.
    */
    public static Collection<Data> Selection2(ArrayList<Data> arr, double level) {
        Collection<Data> col = new ArrayList<>();
        for (Data data : arr) {
            if (Math.abs(data.getValue()) <= level) {
                col.add(data);
            }
        }
        return col;
    }
    /*
     По списку элементов типа Data и множеству names строк выбрать элементы списка,
     имена которых содержатся во множестве names. В качестве результата вернуть
     множество вещественных чисел – значения полей value отобранных элементов.
    */
    public static LinkedHashSet<Double> Selection3(ArrayList<Data> arr, LinkedHashSet<String> names) {
        LinkedHashSet<Double> col = new LinkedHashSet<>();
        for (Data data : arr) {
            for (String str : names) {
                if (data.getName().equals(str)) {
                    col.add(data.getValue());
                }
            }
        }
        return col;
    }
    /*
     По списку элементов типа Data выбрать элементы, для которых значение поля value
     положительное. В качестве результата вернуть массив строк – имен отобранных
     элементов. Массив должен содержать только уникальные имена (т.е. имена без
     повторений).
     */
    public static String[] Selection4(ArrayList<Data> arr) {
        LinkedHashSet<String> col = new LinkedHashSet<>();
        for (Data data : arr) {
            if (data.getValue() > 0) {
                col.add(data.getName());
            }
        }
        String[] sArr = new String[col.size()];
        int k = 0;
        for (String str : col) {
            sArr[k] = str;
            k++;
        }
        return sArr;
    }
    /*
     По списку множеств построить объединение всех множеств списка.
     */
    public static LinkedHashSet<Data> Union(Collection<LinkedHashSet<Data>> col) {
        LinkedHashSet<Data> all = new LinkedHashSet<>();
        for (LinkedHashSet<Data> c : col) {
            all.addAll(c);
        }
        return all;
    }
    /*
     Из списка множеств выбрать все множества максимального размера. Вернуть
     результат в виде списка отобранных множеств.
     */
    public static ArrayList<LinkedHashSet<Data>> MaxSize(Collection<LinkedHashSet<Data>> list) {
        int max = 0;
        for (LinkedHashSet<Data> m : list) {
            if (m.size() > max) {
                max = m.size();
            }
        }
        ArrayList<LinkedHashSet<Data>> Max = new ArrayList<>();
        for (LinkedHashSet<Data> m : list) {
            if (max == m.size()) {
                Max.add(m);
            }
        }
        return Max;
    }
    /*
     По списку множеств построить пересечение всех множеств.
     */
    public static LinkedHashSet<Data> Intersection(Collection<LinkedHashSet<Data>> col) {
        LinkedHashSet<Data> intersection = new LinkedHashSet<>();
        boolean flag = true;
        for (LinkedHashSet<Data> c : col) {
            if (flag) {
                intersection.addAll(c);
                flag = false;
            } else {
                intersection.retainAll(c);
            }
        }
        return intersection;
    }
}
