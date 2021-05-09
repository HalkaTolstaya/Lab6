import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    public BurningShip() {

    }


    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    //Реализует итеративную функцию для фрактала BurningShip
    @Override
    public int numIterations(double x, double y) {
        int i = 0;
        double re = 0;
        double im = 0;

        while ((i < MAX_ITERATIONS) && ((re * re + im * im) < 4)) {
            double rp = re * re - im * im + x;
            double ip = Math.abs(2 * re * im + y);
            re = Math.abs(rp);
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
        return "BurningShip";
    }
}