public class DeterminantRecursion {
   public static double det(double[][] A) { // вычисление определителя рекурсией
        int n = A.length;
        if (n == 1) {
            return A[0][0];
        }
        double ans = 0;
        double[][] B = new double[n-1][n-1];
        int l = 1;
        for(int i = 0; i < n; i++) {
            int x = 0, y = 0;
            for(int j = 1; j < n; j++){
                for(int k = 0; k < n; k++){
                    if (i == k) {
                        continue;
                    }
                    B[x][y] = A[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        x++;
                    }
                }
            }
            ans += l * A[0][i] * det(B);
            l *= (-1);
        }
        return ans;
    }
}
