import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeterminantTest {
    @Test
    void matrixTest() {
        double[] arrT1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Matrix matrix1 = new Matrix(3);
        for (int i = 0; i < arrT1.length; i++) {
            matrix1.setIJ(arrT1[i],i / 3,i % 3);
        }
        assertEquals(0, -matrix1.Determinant());
        double[] arrT2 = { 1, 2, 3, 0, 0, 0, 7, 8, 9 };
        Matrix matrix2 = new Matrix(3);
        for (int i = 0; i < arrT2.length; i++) {
            matrix2.setIJ(arrT2[i],i / 3,i % 3);
        }
        assertEquals(0, matrix2.Determinant());
        double[] arrT3 = { 1, 2, 3, 0, 1, 6, 0, 0, 9 };
        Matrix matrix3 = new Matrix(3);
        for (int i = 0; i < arrT3.length; i++) {
            matrix3.setIJ(arrT3[i],i / 3,i % 3);
        }
        assertEquals(9, matrix3.Determinant());
        Matrix matrix5 = new Matrix(1);
        matrix5.setIJ(5, 0, 0);
        assertEquals(5, matrix5.Determinant());
    }
    @Test
    void diagMatrixTest() {
        double[] arrT1 = { 1, 6, -9, 1, 8, 12, -4, 6, 8 };
        double[] arrT2 = { 1, 6, -9, 999, 8, 12, -4, 0, 0, 9, 8, 11, 0, 0, 5, 9 };
        DiagMatrix diagMatrix1 = new DiagMatrix(arrT1);
        DiagMatrix diagMatrix2 = new DiagMatrix(arrT2);
        assertEquals(995328, diagMatrix1.Determinant());
        assertEquals(0, diagMatrix2.Determinant());
    }
    @Test
    void upTriangleMatrixTest() {
        double[] arrT1 = { 1, 6, -9, 0, 8, 12, 0, 0, 3 };
        double[] arrT2 = { 1, 6, 0, 999 };
        double[] arrT3 = { 0, 6, 0, 999 };
        UpTriangleMatrix upTriangleMatrix1 = new UpTriangleMatrix(3);
        UpTriangleMatrix upTriangleMatrix2 = new UpTriangleMatrix(2);
        UpTriangleMatrix upTriangleMatrix3 = new UpTriangleMatrix(2);
        for (int i = 0; i < arrT1.length; i++) {
            upTriangleMatrix1.setIJ(arrT1[i],i / 3,i % 3);
        }
        for (int i = 0; i < arrT2.length; i++) {
            upTriangleMatrix2.setIJ(arrT2[i],i / 2,i % 2);
        }
        for (int i = 0; i < arrT3.length; i++) {
            upTriangleMatrix3.setIJ(arrT3[i],i / 2,i % 2);
        }
        assertEquals(24, upTriangleMatrix1.Determinant());
        assertEquals(999, upTriangleMatrix2.Determinant());
        assertEquals(0, upTriangleMatrix3.Determinant());
    }



}
