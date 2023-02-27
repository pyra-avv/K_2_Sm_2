import java.util.Arrays;

//import static sun.jvm.hotspot.gc.shared.CollectedHeapName.EPSILON;


public class Matrix implements IMatrix { // квадратная матрица произвольного вида
    private double[] arr;
    private final int n;
    private double det;
    private boolean flag;
    public Matrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Некорректный размер матрицы");
        }
        this.n = n;
        this.arr = new double[n * n];
        for (int i = 0; i < n * n; i++) {
            arr[i] = 0;
        }
        det = 0;
        flag = true;
    }
    public int getN() {
        return n;
    }
    @Override
    public double getIJ(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            throw new IllegalArgumentException("Элемента (" + i + "," + j + ") в матрице нет");
        }
        return arr[i * n + j];
    }
    @Override
    public void setIJ(double e, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            throw new IllegalArgumentException("Элемента (" + i + "," + j + ") в матрице нет");
        }
        arr[i * n + j] = e;
        flag = false;
    }
    @Override
    public double Determinant() { // поиск определителя
        if (!flag) {
            if (ZeroLines(arr)) { // если есть нулевая строка
                det = 0;
            } else {
                double[] m = new double[n * n];
                System.arraycopy(arr, 0, m, 0, n * n);

                double EPSILON = 10e-9;
                int lineSwaps = 0;
                for (int curr = 0; curr < n - 1; curr++) {
                    int max = curr;
                    for (int k = curr; k < n; k++) {
                        if (Math.abs(m[k * n + curr]) > Math.abs(m[max * n + curr])
                                && Math.abs(m[k * n + curr]) < EPSILON) {
                            max = k;
                        }
                    }
                    if (max != curr) {
                        swapLines(m, max, curr);
                        lineSwaps++;
                    }
                    for (int i = curr + 1; i < n; i++) {
                        double coefficient = m[i * n + curr] / m[curr * n + curr];
                        for (int j = 0; j < n; j++) {
                            m[i * n + j] -= m[curr * n + j] * coefficient;
                        }
                    }
                }
                det = 1;
                for (int i = 0; i < n; i++) {
                    det *= m[i * n + i];
                }
                if (lineSwaps % 2 != 0) {
                    det *= -1;
                }
            }
            flag = true;
        }
        return det;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(arr, matrix.arr);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
    public boolean getFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public double getDet() {
        return det;
    }
    public void setDet(double det) {
        this.det = det;
    }
    // приватные вспомогательные функции для нахождения определителя
    private boolean ZeroLines(double[] m) { // проверка на нулевую строку
        double EPSILON = 10e-9;
        for (int i = 0; i < n; i++) {
            boolean flagO = Math.abs(m[i * n]) < EPSILON;
            int j = -1;
            while (++j < n) {
                flagO &= Math.abs(m[i * n + j]) < EPSILON;
            }
            if (flagO) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean flagO = Math.abs(m[i]) < EPSILON;
            int j = -1;
            while (++j < n) {
                flagO &= Math.abs(m[j * n + i]) < EPSILON;
            }
            if (flagO) {
                return true;
            }
        }

        return false;
    }
    private void swapLines(double[] m, int i, int j) { // перестановка строк
        for (int k = 0; k < n; k++) {
            double tmp = m[i * n + k];
            m[i * n + k] = m[j * n + k];
            m[j * n + k] = tmp;
        }
    }









}
