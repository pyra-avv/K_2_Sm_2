import java.util.Comparator;

public class MatrixComparator implements Comparator<Matrix> {
    
    public int compare(Matrix m1, Matrix m2) {
        if (m1.Determinant() == m2.Determinant()) {
            return 0;
        } else if (m1.Determinant() > m2.Determinant()) {
            return 1;
        }
        return -1;
    }
}
