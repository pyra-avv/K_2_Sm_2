public class TEST {
    public static void main(String[] args) {
        double[] arrT3 = { 1, 2, 3, 9, 8, 6, 7, 8, 9 };
        Matrix matrix3 = new Matrix(3);
        for (int i = 0; i < arrT3.length; i++) {
            matrix3.setIJ(arrT3[i],i / 3,i % 3);
        }
        double[][] arrD = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrD[i][j] = matrix3.getIJ(i, j);
            }
        }
        //System.out.print(DeterminantRecursion.DeterminantArr(arrD, 1));




    }
}
