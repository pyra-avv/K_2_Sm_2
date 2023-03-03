import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSetTest {
    @Test
    void DataSetTest1() {
        Data data1 = new Data(5, "rata1");
        Data data2 = new Data(-6, "bata6");
        Data data3 = new Data(0, "cat");
        Data data4 = new Data(55, "fatttttttta");
        Data data5 = new Data(-9, "eata6");
        Data data6 = new Data(-55, "data6");
        Data[] arrData1 = { data1, data2, data3, data4, data5, data6 };
        DataSet dataSet1 = new DataSet();
        for (Data data : arrData1) {
            dataSet1.set(data);
        }
        dataSet1.Sort();
        Data[] arrData2 = { data2, data3, data6, data5, data4, data1 };
        int j = 0;
        for (Object data : dataSet1) {
            assertEquals(arrData2[j], data);
            j++;
        }
//        assertEquals(arrData2[0], dataSet1.get(0));
//        assertEquals(arrData2[1], dataSet1.get(1));
//        assertEquals(arrData2[2], dataSet1.get(2));
//        assertEquals(arrData2[3], dataSet1.get(3));
//        assertEquals(arrData2[4], dataSet1.get(4));
//        assertEquals(arrData2[5], dataSet1.get(5));
    }


}
