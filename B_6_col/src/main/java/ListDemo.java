import java.util.ArrayList;
import java.util.List;

public class ListDemo { // возможно этот класс уже есть // надо спросить
    public static List<Human> Тamesakes(List<Human> listHuman, Human one) {
        List<Human> listRes = new ArrayList<>();
        for (Human human : listHuman) {
            if (human.getSurname().equals(one.getSurname())) {
                listRes.add(human);
            }
        }
        return listRes;
    }
}
