import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JImageDisplay extends javax.swing.JComponent {
    private java.awt.image.BufferedImage bufferedImage;

    /**
     * конструктор
     * @param x ширина
     * @param y высота
     */
    public JImageDisplay(int x, int y) {
        this.bufferedImage = new BufferedImage(x, y, TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(x, y));
    }

    /**
     * устанавливает все пиксели изображения в черный цвет
     */
    public void clearImage() {

    }

    /**
     * устанавливает пиксель в определенный цвет
     * @param x ширина
     * @param y высота
     * @param rgbColor ?цвет?
     */
    public void drawPixel(int x, int y, int rgbColor) {

    }
}
