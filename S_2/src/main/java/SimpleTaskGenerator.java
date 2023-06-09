public class SimpleTaskGenerator implements ITaskGenerator {
    private final SimpleBuffer buffer;
    private int startValue;
    private int amount;

    public SimpleTaskGenerator(SimpleBuffer buffer, int startValue, int amount) {
        this.buffer = buffer;
        this.startValue = startValue;
        this.amount = amount;
    }
    @Override
    public void generate() {
        int n = amount;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = startValue + i;
        }
        Task task = new Task(arr);
        buffer.set(task);
    }
    public SimpleTaskGenerator withStartValue(int startValue) {
        this.startValue = startValue;
        return this;
    }
    public SimpleTaskGenerator withAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
