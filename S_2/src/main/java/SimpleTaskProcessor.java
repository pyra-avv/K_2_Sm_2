public class SimpleTaskProcessor implements ITaskProcessor {
    private final SimpleBuffer buffer;
    public SimpleTaskProcessor(SimpleBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public Integer process() {
        if (!buffer.noNull()) {
            return null;
        }
        int[] task = buffer.get().getData();
        int res = 0;
        for (int i : task) {
            res += i;
        }
        return res;
    }
}
