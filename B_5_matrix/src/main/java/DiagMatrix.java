public class DiagMatrix extends UpTriangleMatrix implements IMatrix { // диагональная матрица
    public DiagMatrix(int n) {
        super(n);
    }
    public DiagMatrix(double[] ArrD) {
        super(ArrD.length);
        for (int i = 0; i < ArrD.length; i++) {
            for (int j = 0; j < ArrD.length; j++) {
                if (i == j) {
                    setIJ(ArrD[i], i, j);
                } else {
                    setIJ(0, i, j);
                }
            }
        }
    }
    @Override
    public void setIJ(double e, int i, int j) {
        if (i != j && e != 0) {
             throw new IllegalArgumentException("Элемент (" + i + "," + j + ") нельзя изменить");
        }
        super.setIJ(e, i, j);
    }
}
