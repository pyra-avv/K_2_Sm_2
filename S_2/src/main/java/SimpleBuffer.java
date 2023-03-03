import java.util.Queue;

public class SimpleBuffer implements IBuffer{
    private Queue<Object> queue;
    public SimpleBuffer(Queue<Object> queue) {
        this.queue = queue;
    }
    @Override
    public void set(Object e) {
        queue.offer(e);
    }
    @Override
    public Object get() {
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
