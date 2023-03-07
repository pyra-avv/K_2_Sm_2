public class SimpleTaskProcessor implements ITaskProcessor {
    private SimpleBuffer buffer;
    public SimpleTaskProcessor(SimpleBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public int process(Task task) {

    }
}
