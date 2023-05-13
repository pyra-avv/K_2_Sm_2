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
    public static final Lambda5 lambda6 = (human1, human2) -> human1.equals(human2);
    /**
     * 7) получить фамилию, имя и отчество человека в виде одной строки (разделитель пробел)
     */
    public static final Lambda6 lambda7 = human -> human.getSurname() + " " +
            human.getName() + " " + human.getPatronymic();
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