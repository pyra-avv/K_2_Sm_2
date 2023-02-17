import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {
    @Test
    void serviceTest1() {
        Data data1 = new Data(5, "data1");
        Data data2 = new Data(-6, "data6");
        Data data3 = new Data(0, "dat");
        Data data4 = new Data(55, "datttttttta");
        Data data5 = new Data(-9, "data6");
        Data data6 = new Data(-55, "data6");
        ArrayList<Data> dataListTest =
                new ArrayList<>(List.of(new Data[] { data1, data2, data3, data5, data4, data6 }));

        Collection<Data> dataList1 = new ArrayList<>(List.of(new Data[] { data2, data5, data6 }));
        assertEquals(dataList1, Service.Selection1(dataListTest, "data6"));

        Collection<Data> dataList2= new ArrayList<>(List.of(new Data[] { data1, data2, data3, data5 }));
        assertEquals(dataList2, Service.Selection2(dataListTest, 40));

        LinkedHashSet<Double> doubleSet1 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Double[] { 5.0, -6.0, -9.0, -55.0 })));
        LinkedHashSet<String> stringSet1
                = new LinkedHashSet<>(new ArrayList<>(List.of(new String[] { "data1", "data6" })));
        assertEquals(doubleSet1, Service.Selection3(dataListTest, stringSet1));

        String[] stringArr1 = { "data1", "datttttttta" };
        assertArrayEquals(stringArr1, Service.Selection4(dataListTest));
    }
    @Test
    void serviceTest2() {
        Data data1 = new Data(5, "data1");
        Data data2 = new Data(-6, "data6");
        Data data3 = new Data(0, "dat");
        Data data4 = new Data(55, "datttttttta");
        Data data5 = new Data(-9, "data6");
        Data data6 = new Data(-55, "data6");
        LinkedHashSet<Data> dataSet1 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data1, data2, data3 })));
        LinkedHashSet<Data> dataSet2 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data5, data4, data6 })));
        LinkedHashSet<Data> dataSet3 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data5, data1, data3 })));
        LinkedHashSet<Data> dataSet4 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data1, data3 })));
        Collection<LinkedHashSet<Data>> test12 = new ArrayList<>();
        test12.add(dataSet1);
        test12.add(dataSet2);
        Collection<LinkedHashSet<Data>> test23 = new ArrayList<>();
        test23.add(dataSet2);
        test23.add(dataSet3);
        ArrayList<LinkedHashSet<Data>> test234 = new ArrayList<>();
        test234.add(dataSet2);
        test234.add(dataSet3);
        test234.add(dataSet4);

        LinkedHashSet<Data> union12 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data1, data2, data3, data5, data4, data6 })));
        LinkedHashSet<Data> union23 =
                new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data5, data4, data6, data1, data3 })));
        assertEquals(union12, Service.Union(test12));
        assertEquals(union23, Service.Union(test23));

        LinkedHashSet<Data> intersection12 = new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { })));
        LinkedHashSet<Data> intersection23 = new LinkedHashSet<>(new ArrayList<>(List.of(new Data[] { data5 })));
        assertEquals(intersection12, Service.Intersection(test12));
        assertEquals(intersection23, Service.Intersection(test23));

        assertEquals(test23, Service.MaxSize(test234));
    }
}
