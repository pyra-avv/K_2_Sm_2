import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBufferTest {
    @Test
    void SimpleBufferTest1() {
        Queue<Task> taskQueue = new LinkedList<>();
        Task task1 = new Task(595, 926, 556, 65);
        taskQueue.add(task1);
        taskQueue.add(new Task(1, 9, 6));
        taskQueue.add(new Task(1, 5));
        SimpleBuffer buffer1 = new SimpleBuffer(taskQueue);
        assertTrue(buffer1.noNull());
        assertEquals(3, buffer1.getSize());
        assertEquals(task1, buffer1.get());
        Task task2 = new Task(595, 926, 65);
        buffer1.set(task2);
        assertEquals(task1, buffer1.get());
        buffer1.del();;
        assertFalse(buffer1.noNull());
    }
}