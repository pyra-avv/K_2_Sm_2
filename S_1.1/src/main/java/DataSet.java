import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataSet {
    private ArrayList<Data> list;
    public DataSet() {
        this.list = new ArrayList<>();
    }
    public void setAdd(Data data) {
        list.add(data);
    }
//    @Override
//    public Iterator<Data>() {
//        return new Iterator<Data>()
//        {
//            private int i = 0;
//            @Override
//            public boolean hasNext() {
//                return (i < list.size() && array[i] != null);
//            }
//            @Override
//            public Data next()
//            {
//                if (!hasNext()) {
//                    throw new NoSuchElementException();
//                }
//                return array[i++];
//            }
//        };
//    }

}
