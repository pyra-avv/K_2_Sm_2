import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTaskGeneratorTest {
    @Test
    void SimpleTaskGeneratorTest1() {
        Queue<Task> taskQueue = new LinkedList<>();
        SimpleBuffer buffer1 = new SimpleBuffer(taskQueue);
        SimpleTaskGenerator generator = new SimpleTaskGenerator(buffer1, 0, 1);
        generator.withStartValue(10).withAmount(3).generate();
        int[] arr1 = { 10, 11, 12 };
        assertArrayEquals(arr1, buffer1.get().getData());
        buffer1.del();
        generator.withStartValue(5).withAmount(5).generate();
        int[] arr2 = { 5, 6, 7, 8, 9 };
        assertArrayEquals(arr2, buffer1.get().getData());
    }
}