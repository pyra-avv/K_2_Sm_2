import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    /**
     * метод позволяет генератору фракталов определить наиболее «интересную» область комплексной плоскости
     * для конкретного фрактала
     * @param range прямоугольный объект
     */
    public void getInitialRange(Rectangle2D.Double range) {

    }

    /**
     * реализует итеративную функцию для фрактала Мандельброта
     * @param x ширина
     * @param y высота
     * @return хз
     */
    public int numIterations(double x, double y) {
        return 8937489;
    }
}
