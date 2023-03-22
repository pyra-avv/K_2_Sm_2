import java.io.Serializable;
import java.util.Objects;

public class Data implements Serializable {
    private int dey;
    private String month;
    private int year;
    public Data() { // Конструктор по умолчанию
        this.dey = 1;
        this.month = "январь";
        this.year = 2000;
    }
    public Data(int Dey, String Month, int Year) { // Конструктор принимающий месяц строкой
        setMonth(Month);
        setYear(Year);
        setDey(Dey);
    }
    public Data(int Dey, int Month, int Year) { // Конструктор, принимающий месяц числом
        setYear(Year);
        if (Month <= 0 || Month > 12) {
            this.month = "январь";
        } else {
            String[] arr = { "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь",
                    "октябрь", "ноябрь", "декабрь" };
            this.month = arr[Month - 1];
        }
        setDey(Dey);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return dey == data.dey && year == data.year && Objects.equals(month, data.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dey, month, year);
    }

    /*public boolean DataData(Data x) {
            if (year != x.year) {
                if ((year - x.year == 1) && (dey == 1) && (x.dey == 31) && (month.equals("январь")) &&
                        (x.month.equals("декабрь"))) {
                    return true;
                } else {
                    return false;
                }
            } else if (!x.month.equals(month)) {
                if (mont)

            } else {

            }
        }*/
    public void setDey(int dey) {
        if (dey <= 0 || dey > 31) {
            this.dey = 1;
        } else if (dey == 31 && (month.equals("апрель") || month.equals("июнь") ||
                month.equals("сентябрь") || month.equals("октябрь"))) {
            this.dey = 30;
        } else if ((dey == 30 && month.equals("февраль")) || (dey == 29 && month.equals("февраль") && year % 4 != 0)) {
            this.dey = 28;
        } else {
            this.dey = dey;
        }
    }
    public void setMonth(String Month) {
        if (!Month.equals("январь") && !Month.equals("февраль") && !Month.equals("март") && !Month.equals("апрель") &&
                !Month.equals("май") && !Month.equals("июнь") && !Month.equals("июль") && !Month.equals("август") &&
                !Month.equals("сентябрь") && !Month.equals("октябрь") && !Month.equals("ноябрь") &&
                !Month.equals("декабрь")) {
            this.month = "январь";
        } else {
            this.month = Month;
        }
    }
    public void setYear(int year) {
        if (year < 1970) {
            this.year = 1970;
        } else {
            this.year = year;
        }
    }
    public int getDey() {
        return dey;
    }
    public String getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
}
