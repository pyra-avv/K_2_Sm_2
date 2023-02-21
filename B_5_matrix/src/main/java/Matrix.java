import java.util.Arrays;

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
    public double Determinant() {
        if (!flag) {
            double[][] arrD = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arrD[i][j] = getIJ(i, j);
                }
            }
//            int countSwaps = 1;
//            for (int i = 0; i < n; ++ i)
//            {
//                // находим строку с максимальным первым элементом
//                int iMax = i;
//                for (int j = i + 1; j < n; ++ j)
//                    if (Math.abs.(arrD[j][i]) > Math.abs.(arrD[iMax][i]))
//                        iMax = j;
//                if (Math.abs.(arrD[iMax][i]) < eps))
//                    continue;
//                for (int k = 0; k < n; ++ k)
//                    Arrays.swap.(arrD[i][k], arrD[iMax][k]);
//                countSwaps = - countSwaps * (i != iMax ? 1 : - 1);
//
//                //  вычитаем текущую строку из всех остальных
//                for (int j = i + 1; j < n; ++ j) {
//                    double q = - arrD[j][i] / arrD[i][i];
//                    for (int k = n - 1; k >= i; k--) {
//                        arrD[j][k] += q * arrD[i][k];
//                    }
//                }
//            }




            det = 1;
            for (int i = 0; i < n; i++) {
                det *= arrD[i][i];
            }
            //det = DeterminantRecursion.det(arrD);
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
}
