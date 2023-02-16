import java.util.Arrays;

public class Matrix implements IMatrix { // квадратная матрица произвольного вида
    private double[] arr;
    private double det;
    private boolean flag;
    public Matrix(int n) {
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
        arr[i * getN() + j] = e;
        flag = false;
    }
    @Override
    public double Determinant() { // вообще не уверен что эта хрень работает
        if (!flag) {
            double[][] arrD = new double[getN()][getN()];
            for (int i = 0; i < getN(); i++) {
                for (int j = 0; j < getN(); j++) {
                    arrD[i][j] = getIJ(i, j);
                }
            }
            det = DeterminantRecursion.det(arrD);
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
}
