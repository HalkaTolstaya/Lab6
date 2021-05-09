import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JPanel {

    private int width;
    private int height;
    private BufferedImage img;
    private Graphics g;

    //Конструкторы
    public JImageDisplay() {

    }

    public JImageDisplay(int size) {
        this(size, size);
    }

    public JImageDisplay(int width, int height) {
        this.width = width;
        this.height = height;
        img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        g = img.getGraphics();
        this.repaint();
    }
    //Перерисовка
    public void repaintPicture() {
        this.repaint();
    }
    public void repaintPicture(int x, int y, int width) {
        this.repaint(0, x, y, width, 1);
    }

    //Рисование
    public void drawPixel(int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
        this.repaint();
    }

    //Реакция на рисовании
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    //Очистка
    public void clearImage() {
        g.setColor(Color.black);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        this.repaint();
    }

    public BufferedImage getImage() {
        return img;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}