public class SimpleTaskProcessor implements ITaskProcessor {
    private final SimpleBuffer buffer;
    public SimpleTaskProcessor(SimpleBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public int process() {
        if (!buffer.noNull()) {
            return Integer.parseInt(null);
        }
        int[] task = buffer.get().getData();
        int res = 0;
        for (int i : task) {
            res += i;
        }
        return res;
    }
}
