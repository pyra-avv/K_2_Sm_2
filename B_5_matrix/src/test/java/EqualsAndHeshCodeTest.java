import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualsAndHeshCodeTest {
    @Test
    void matrixTest() {
        double[] arrT1 = { 1, 6, -9, 999, 8, 12, -4, 0, 0 };
        double[] arrT2 = { 1, 6, -9, 999, 8, 12, -4, 0, 0, 9, 8, 11, 0, 0, 5, 9 };
        Matrix matrix1 = new Matrix(3);
        Matrix matrix2 = new Matrix(4);
        Matrix matrix3 = new Matrix(3);
        for (int i = 0; i < arrT1.length; i++) {
            matrix1.setIJ(arrT1[i],i / 3,i % 3);
        }
        for (int i = 0; i < arrT2.length; i++) {
            matrix2.setIJ(arrT2[i],i / 4,i % 4);
        }
        matrix3.setIJ(1, 0, 0);
        matrix3.setIJ(6, 0, 1);
        matrix3.setIJ(-9, 0, 2);
        matrix3.setIJ(999, 1, 0);
        matrix3.setIJ(8, 1, 1);
        matrix3.setIJ(12, 1, 2);
        matrix3.setIJ(-4, 2, 0);
        matrix3.setIJ(0, 2, 1);
        matrix3.setIJ(0, 2, 2);
        assertEquals(matrix1, matrix3);
        assertNotEquals(matrix1, matrix2);
        assertNotEquals(matrix3, matrix2);
    }
    @Test
    void diagMatrixTest() {
        double[] arrT = { 1, 6, -9, 999, 8, 12, -4, 0, 0 };
        double[] arrT2 = { 1, 6, -9, 999, 8, 12, -4, 0, 0, 9, 8, 11, 0, 0, 5, 9 };
        DiagMatrix diagMatrix1 = new DiagMatrix(9);
        for (int i = 0; i < arrT.length; i++) {
            diagMatrix1.setIJ(arrT[i], i , i);
        }
        DiagMatrix diagMatrix2 = new DiagMatrix(arrT);
        DiagMatrix diagMatrix3 = new DiagMatrix(arrT2);
        DiagMatrix diagMatrix4 = new DiagMatrix(9);
        diagMatrix4.setIJ(1, 0, 0);
        diagMatrix4.setIJ(6, 1, 1);
        diagMatrix4.setIJ(-9, 2, 2);
        diagMatrix4.setIJ(999, 3, 3);
        diagMatrix4.setIJ(8, 4, 4);
        diagMatrix4.setIJ(12, 5, 5);
        diagMatrix4.setIJ(-4, 6, 6);
        diagMatrix4.setIJ(0, 7, 7);
        diagMatrix4.setIJ(0, 8, 8);
        assertEquals(diagMatrix1, diagMatrix2);
        assertEquals(diagMatrix1, diagMatrix4);
        assertEquals(diagMatrix2, diagMatrix4);
        assertNotEquals(diagMatrix1, diagMatrix3);
        assertNotEquals(diagMatrix2, diagMatrix3);
    }
    @Test
    void upTriangleMatrixTest() {
        double[] arrT = { 1, 6, -9, 0, 8, 12, 0, 0, 666 };
        double[] arrT2 = { 1, 6, 0, 999 };
        UpTriangleMatrix upTriangleMatrix1 = new UpTriangleMatrix(3);
        UpTriangleMatrix upTriangleMatrix2 = new UpTriangleMatrix(2);
        UpTriangleMatrix upTriangleMatrix3 = new UpTriangleMatrix(3);
        for (int i = 0; i < arrT.length; i++) {
            upTriangleMatrix1.setIJ(arrT[i],i / 3,i % 3);
        }
        for (int i = 0; i < arrT2.length; i++) {
            upTriangleMatrix2.setIJ(arrT2[i],i / 2,i % 2);
        }
        upTriangleMatrix3.setIJ(1, 0, 0);
        upTriangleMatrix3.setIJ(6, 0, 1);
        upTriangleMatrix3.setIJ(-9, 0, 2);
        upTriangleMatrix3.setIJ(0, 1, 0);
        upTriangleMatrix3.setIJ(8, 1, 1);
        upTriangleMatrix3.setIJ(12, 1, 2);
        upTriangleMatrix3.setIJ(0, 2, 0);
        upTriangleMatrix3.setIJ(0, 2, 1);
        upTriangleMatrix3.setIJ(666, 2, 2);
        assertEquals(upTriangleMatrix1, upTriangleMatrix3);
        assertNotEquals(upTriangleMatrix1, upTriangleMatrix2);
        assertNotEquals(upTriangleMatrix3, upTriangleMatrix2);
    }
}
