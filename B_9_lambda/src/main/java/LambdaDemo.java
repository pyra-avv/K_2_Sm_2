import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaDemo {
    /**
     * 1) для строки символов получить ее длину
     */
    public static final Function<String, Integer> lambda1 = String::length;
    /**
     * 2) для строки символов получить ее первый символ, если он существует, или null иначе
     */
    public static final Function<String, Character> lambda2 = str -> {
      if (str != null && !str.isEmpty()) {
          return str.charAt(0);
      }
      return null;
    };
    /**
     * 3) для строки проверить, что она не содержит пробелов
     */
    public static final Function<String, Boolean> lambda3 = str -> str.split(" ").length == 1;
    /**
     * 4) слова в строке разделены запятыми, по строке получить количество слов в ней
     */
    public static final Function<String, Integer> lambda4 = str -> {
        int k = 0;
        for (String s : str.split(",")) {
            if (!s.equals("")) {
                k++;
            }
        }
        return k;
    };
    /**
     * 5) по человеку получить его возраст
     */
    public static final Function<Human, Integer> lambda5 = Human::getAge;
    /**
     * 6) по двум людям проверить, что у них одинаковая фамилия
     */
    public static final BiFunction<Human, Human, Boolean> lambda6 = (human1, human2) ->
            human1.getSurname().equals(human2.getSurname());
    /**
     * 7) получить фамилию, имя и отчество человека в виде одной строки (разделитель пробел)
     */
    public static final Function<Human, String> lambda7 = human -> human.getSurname() + " " + human.getName() + " " +
            human.getPatronymic();
    /**
     * 8) сделать человека старше на один год (по объекту Human создать новый объект)
     */
    public static final Function<Human, Human> lambda8 = human -> new Human(human.getSurname(), human.getName(),
            human.getPatronymic(), human.getAge() + 1, human.getSex());
    /**
     * 9) по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
     */
    public static final Function4<Human, Human, Human, Integer, Boolean> lambda9 = (human1, human2, human3, maxAge) ->
            human1.getAge() < maxAge && human2.getAge() < maxAge && human3.getAge() < maxAge;

}

@FunctionalInterface
interface Function4<T, U, Q, P, R> {
    R apply(T t, U u, Q q, P p);
}