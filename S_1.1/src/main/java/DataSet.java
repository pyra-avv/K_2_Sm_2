import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataSet {
    private ArrayList<Data> list;
    public DataSet() {
        this.list = new ArrayList<>();
    }
    public void set(Data data) {
        list.add(data);
    }
    public Data get(int i) {
        return list.get(i);
    }
    public void Sort() {



    }





}