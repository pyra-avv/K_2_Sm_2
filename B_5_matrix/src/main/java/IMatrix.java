public interface IMatrix { // квадратная матрица вещественных чисел
    double getIJ(int i, int j); // получить элемент с заданными индексами
    void setIJ(double e, int i, int j); // изменить элемент с заданными индексами
    double Determinant(); // вычислить определитель матрицы
}
