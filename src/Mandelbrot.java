import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;

    public Mandelbrot() {

    }

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    //Реализует итеративную функцию для фрактала Mandelbrot
    @Override
    public int numIterations(double x, double y) {
        int i = 0;
        double re = 0;
        double im = 0;

        while ((i < MAX_ITERATIONS) && ((re * re + im * im) < 4)) {
            double rp = re * re - im * im + x;
            double ip = 2 * re * im + y;
            re = rp;
            im = ip;
            i += 1;
        }
        if (i == MAX_ITERATIONS)
            return -1;
        else
            return i;
    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}