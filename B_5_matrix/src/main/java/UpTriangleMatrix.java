import java.util.Arrays;

public class UpTriangleMatrix implements IMatrix { // верхнетреугольная матрица
    private double[] arr;
    private double det;
    private boolean flag;
    public UpTriangleMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Некорректный размер матрицы");
        }
        this.arr = new double[n * n];
        for (int i = 0; i < n * n; i++) {
            arr[i] = 0;
        }
        flag = false;
    }
    public int getN() {
        return (int) Math.sqrt(arr.length);
    }
    @Override
    public double getIJ(int i, int j) {
        if (i < 0 || j < 0 || i >= getN() || j >= getN()) {
            throw new IllegalArgumentException("Этого элемента в матрице нет");
        }
        return arr[i * getN() + j];
    }
    @Override
    public void setIJ(double e, int i, int j) {
        if (i < 0 || j < 0 || i >= getN() || j >= getN()) {
            throw new IllegalArgumentException("Этого элемента в матрице нет");
        }
        if (i < j && e != 0) {
            throw new IllegalArgumentException("Этот элемент нельзя изменить");
        }
        arr[i * getN() + j] = e;
        flag = false;
    }
    @Override
    public double Determinant() {
        if (!flag) {
            det = 1;
            for (int i = 0; i < getN(); i++) {
                det *= getIJ(i, i);
            }
            flag = true;
        }
        return det;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpTriangleMatrix that = (UpTriangleMatrix) o;
        return Arrays.equals(arr, that.arr);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}
