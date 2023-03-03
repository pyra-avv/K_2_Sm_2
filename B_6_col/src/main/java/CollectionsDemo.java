import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class CollectionsDemo {
    public static int FirstSymbol(Collection<String> arrStr, char s) {
        int res = 0;
        for (String str : arrStr) {
            if (s == str.charAt(0)) {
                res++;
            }
        }
        return res;
    }
    public static List<LinkedHashSet<Integer>> NotIntersect(List<LinkedHashSet<Integer>> listSet,
                                                            LinkedHashSet<Integer> set) {

    }

}
