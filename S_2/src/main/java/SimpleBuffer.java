import java.util.Queue;

public class SimpleBuffer implements IBuffer{
    private final Queue<Task> queue;
    public SimpleBuffer(Queue<Task> queue) {
        this.queue = queue;
    }
    @Override
    public void set(Task e) {
        queue.offer(e);
    }
    @Override
    public Task get() {
        return queue.element();
    }
    @Override
    public int getSize() {
        return queue.size();
    }
    @Override
    public void del() {
        Object e = queue.poll();
        while (e != null) {
            e = queue.poll();
        }
    }
    @Override
    public boolean noNull() {
        return queue.peek() != null;
    }
}
