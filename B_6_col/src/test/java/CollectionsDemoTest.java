import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {
    @Test
    void firstSymbol() {
        Collection<String> colStr1 = new ArrayList<>(List.of("col", "", "cpp", "asb", "set" ));
        assertEquals(2, CollectionsDemo.FirstSymbol(colStr1, 'c'));
        assertEquals(0, CollectionsDemo.FirstSymbol(colStr1, 'e'));
    }
    @Test
    void sameSurnames() {
        List<Human> listHuman1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",5),
                new Human("Петров", "Иван", "Иваныч",17),
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Human("Иванов", "Сергей", "Иваныч",10) ));
        Human human1 = new Human("Иванов", "Иван",  "Gtnhjdbx", 80);
        List<Human> listRes = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",5),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        assertEquals(listRes, CollectionsDemo.SameSurnames(listHuman1,  human1));
    }

    @Test
    void listWithoutOne() {
        ArrayList<Human> listHuman1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",5),
                new Human("Петров", "Иван", "Иваныч",17),
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        Human human1 = new Human("Бочаров", "Сергей", "Иваныч",10);
        ArrayList<Human> listRes1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",5),
                new Human("Петров", "Иван", "Иваныч",17),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        ArrayList<Human> listRes = CollectionsDemo.ListWithoutOne(listHuman1, human1);
        assertEquals(listRes1, listRes);
        listHuman1.get(0).setAge(333);
        assertEquals(listRes1, listRes);
    }

    @Test
    void notIntersect() {
        Set<Integer> setInt1 = new HashSet<>(Set.of(5, 8, 77, 16));
        Set<Integer> setInt2 = new HashSet<>(Set.of(51, 8, 55, 78, 909));
        Set<Integer> setInt3 = new HashSet<>(Set.of(5, 78, 44, 16));
        Set<Integer> setInt4 = new HashSet<>(Set.of(5, 555, 77, 16, 6));
        List<Set<Integer>> listTest1 = new ArrayList<>(List.of(setInt1, setInt2, setInt3, setInt4));

        Set<Integer> setTest1 = new HashSet<>(Set.of(9999, 5555, 6666));
        assertEquals(listTest1, CollectionsDemo.NotIntersect(listTest1, setTest1));

        Set<Integer> setTest2 = new HashSet<>(Set.of(77, 8));
        List<Set<Integer>> listTest2 = new ArrayList<>(List.of(setInt3));
        assertEquals(listTest2, CollectionsDemo.NotIntersect(listTest1, setTest2));
    }
    @Test
    void maxAge() {
        List<Human> listHuman1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",25),
                new Human("Петров", "Иван", "Иваныч",25),
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Student("Ce[jigfkjd", "Иван", "Иваныч",25, "imit"),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        Set<Human> setTest1 = new HashSet<>(Set.of(
                new Human("Иванов", "Иван", "Иваныч",25),
                new Human("Петров", "Иван", "Иваныч",25),
                new Student("Ce[jigfkjd", "Иван", "Иваныч",25, "imit")));
        assertEquals(setTest1, CollectionsDemo.MaxAge(listHuman1));
    }
    @Test
    void display() {
        Map<Integer, Human> mapHuman1 = mapIntHuman();
        Set<Integer> setInt1 = new HashSet<>(Set.of(66, 8, 99));
        Set<Human> resHuman1 = new HashSet<>(Set.of(
                new Human("Иванов", "Сергей", "Иваныч",10),
                new Human("Бочаров", "Сергей", "Иваныч",10)));
        assertEquals(resHuman1, CollectionsDemo.Display(mapHuman1, setInt1));
        Set<Integer> setInt2 = new HashSet<>(Set.of(66, 88, 87));
        Set<Human> resHuman2 = new HashSet<>();
        assertEquals(resHuman2, CollectionsDemo.Display(mapHuman1, setInt2));
    }
    @Test
    void listOfAdults() {
        Map<Integer, Human> mapHuman1 = mapIntHuman();
        List<Integer> resInt1 = new ArrayList<>(List.of(5, 6, 77));
        assertEquals(resInt1, CollectionsDemo.ListOfAdults(mapHuman1));
    }
    @Test
    void toAge() {
        Map<Integer, Human> mapHuman1 = mapIntHuman();
        Map<Integer, Integer> mapInt1 = new HashMap<>();
        for (Map.Entry<Integer, Human> m : mapHuman1.entrySet()) {
            mapInt1.put(m.getKey(), m.getValue().getAge());
        }
        assertEquals(mapInt1, CollectionsDemo.toAge(mapHuman1));
    }
    @Test
    void newMap() {
        Set<Human> setHuman = new HashSet<>(Set.of(
                new Human("Иванов", "Иван", "Иваныч",25),
                new Human("Петров", "Иван", "Иваныч",25),
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        List<Human> listHuman1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",25),
                new Human("Петров", "Иван", "Иваныч",25)));
        List<Human> listHuman2 = new ArrayList<>(List.of(
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        List<Human> listHuman3 = new ArrayList<>(List.of(
                new Human("Вертихвостов", "Иван", "Иваныч",20)));
        Map<Integer, List<Human>> mapRes = new HashMap<>();
        mapRes.put(25, listHuman1);
        mapRes.put(10, listHuman2);
        mapRes.put(20, listHuman3);
        assertEquals(mapRes, CollectionsDemo.NewMap(setHuman));
    }
    Map<Integer, Human> mapIntHuman() {
        List<Human> listHuman1 = new ArrayList<>(List.of(
                new Human("Иванов", "Иван", "Иваныч",25),
                new Human("Петров", "Иван", "Иваныч",25),
                new Human("Бочаров", "Сергей", "Иваныч",10),
                new Human("Вертихвостов", "Иван", "Иваныч",20),
                new Human("Иванов", "Сергей", "Иваныч",10)));
        int[] arrInt1 = { 5, 6, 99, 77, 8 };
        Map<Integer, Human> mapHuman1 = new HashMap<>();
        int k = 0;
        for (Human human : listHuman1) {
            mapHuman1.put(arrInt1[k], human);
            k++;
        }
        return mapHuman1;
    }
}