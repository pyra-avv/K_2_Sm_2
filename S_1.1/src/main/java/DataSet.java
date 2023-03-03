import java.util.*;

import static java.util.Collections.sort;

public  class DataSet implements Iterable<ArrayList<Data>>, Iterator<ArrayList<Data>> {
    private ArrayList<Data> list;
    private int count = 0;
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
        Collections.sort(list);
    }

    public boolean hasNext() {
        if (count < list.size()) {
            return true;
        }
        return false;
    }
    public Data next() {
        if (count == list.size()) {
            throw new NoSuchElementException();
        }
        count++;
        return get(count - 1);
    }
    public void remove () {
        throw new UnsupportedOperationException();
    }
    public Iterator<ArrayList<Data>> iterator() {
        return this;
    }
}
