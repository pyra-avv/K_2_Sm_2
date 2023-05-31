import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixServiceTest {

    @Test
    void arrangeMatrices() {
        double[] arrT1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Matrix matrix1 = new Matrix(3);
        for (int i = 0; i < arrT1.length; i++) {
            matrix1.setIJ(arrT1[i],i / 3,i % 3);
        } // 0
        double[] arrT3 = { 1, 2, 3, 0, 1, 6, 0, 0, 9 };
        Matrix matrix3 = new Matrix(3);
        for (int i = 0; i < arrT3.length; i++) {
            matrix3.setIJ(arrT3[i],i / 3,i % 3);
        } // 9
        Matrix matrix5 = new Matrix(1);
        matrix5.setIJ(5, 0, 0);
        // 5
        double[] arrT5 = { 1, 6, -9, 1, 8, 12, -4, 6, 8 };
        DiagMatrix diagMatrix2 = new DiagMatrix(arrT5);
        // 99999

        Matrix[] arrM = { matrix3, diagMatrix2, matrix1, matrix5 };
        assertArrayEquals(new Matrix[] { matrix1, matrix5, matrix3, diagMatrix2 }, MatrixService.arrangeMatrices(arrM));
    }
}