import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTaskProcessorTest {

    @Test
    void process() {
        Queue<Task> taskQueue = new LinkedList<>();
        SimpleBuffer buffer1 = new SimpleBuffer(taskQueue);
        SimpleTaskProcessor processor1 = new SimpleTaskProcessor(buffer1);
        assertNull(processor1.process());
        SimpleTaskGenerator generator = new SimpleTaskGenerator(buffer1, 0, 1);
        generator.withStartValue(10).withAmount(3).generate();
        assertEquals(33, processor1.process());
    }
}