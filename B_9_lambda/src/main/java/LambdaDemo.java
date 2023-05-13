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
    public static final Lambda5 lambda6 = (human1, human2) -> human1.getSurname().equals(human2.getSurname());
    /**
     * 7) получить фамилию, имя и отчество человека в виде одной строки (разделитель пробел)
     */
    public static final Lambda6 lambda7 = human -> human.getSurname() + " " + human.getName() + " " +
            human.getPatronymic();
    /**
     * 8) сделать человека старше на один год (по объекту Human создать новый объект)
     */
    public static final Lambda7 lambda8 = human -> new Human(human.getSurname(), human.getName(), human.getPatronymic(),
            human.getAge() + 1, human.getSex());
    /**
     * 9) по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
     */
    public static final Lambda8 lambda9 = (human1, human2, human3, maxAge) -> human1.getAge() < maxAge &&
            human2.getAge() < maxAge && human3.getAge() < maxAge;
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

interface Lambda7 {
    Human HumanHu(Human human);
}

interface Lambda8 {
    boolean Human3IntBu(Human human1, Human human2, Human human3, int maxAge);
}