public class UpTriangleMatrix extends Matrix implements IMatrix { // верхнетреугольная матрица
    public UpTriangleMatrix(int n) {
        super(n);
    }
    @Override
    public void setIJ(double e, int i, int j) {
        if (i > j && e != 0) {
            throw new IllegalArgumentException("Элемент (" + i + "," + j + ") нельзя изменить");
        }
        super.setIJ(e, i, j);
    }
    @Override
    public double Determinant() {
        if (!getFlag()) {
            double d = 1;
            for (int i = 0; i < getN(); i++) {
                d *= getIJ(i, i);
            }
            setFlag(true);
            setDet(d);
        }
        return getDet();
    }
}
