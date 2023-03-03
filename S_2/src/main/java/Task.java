import java.util.Arrays;

public class Task implements ITask {
    private final int[] arr;
    public Task(int... x) {
        this.arr = new int[x.length];
        int j = 0;
        for (int e : x) {
            arr[j] = e;
            j++;
        }
    }
    @Override
    public int[] getData() {
        return arr;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Arrays.equals(arr, task.arr);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}
