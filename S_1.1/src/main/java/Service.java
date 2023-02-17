import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class Service {
    public static Collection<String> Selection1(ArrayList<Data> arr, String name) {
        Collection<String> col = new ArrayList<>();
        for (Data data : arr) {
            if (data.getName().equals(name)) {
                col.add(data.getName());
            }
        }
        return col;
    }
    public static Collection<Double> Selection2(ArrayList<Data> arr, double level) {
        Collection<Double> col = new ArrayList<>();
        for (Data data : arr) {
            if (Math.abs(data.getValue()) <= level) {
                col.add(data.getValue());
            }
        }
        return col;
    }
    public static LinkedHashSet<Double> Selection3(ArrayList<Data> arr, String[] names) {
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
    public static String[] Selection4(ArrayList<Data> arr) {
        LinkedHashSet<String> col = new LinkedHashSet<>();
        for (Data data : arr) {
            if (Math.abs(data.getValue()) > 0) {
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
    // надо делать с датой
    public static LinkedHashSet<Data> Union(Collection<LinkedHashSet<Data>> col) {
        LinkedHashSet<Data> all = new LinkedHashSet<>();
        for (LinkedHashSet<Data> c : col) {
            all.addAll(c);
        }
        return all;
    }
    public static ArrayList<LinkedHashSet<Data>> MaxSize(ArrayList<LinkedHashSet<Data>> list) {
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
    public static LinkedHashSet<Data> Intersection(Collection<LinkedHashSet<Data>> col) {
        LinkedHashSet<Data> intersection = new LinkedHashSet<>();
        for (LinkedHashSet<Data> c : col) {
            intersection.retainAll(c);
        }
        return intersection;
    }
}
