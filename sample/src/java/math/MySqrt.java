package math;

/**
 * Created by junm5 on 5/27/17.
 */
public class MySqrt {

    private static final double epsilon = 1e-15;

    public static double sqrtUsingBST(double a) {
        if (a < 0) {
            if (a < 0) return Double.NaN;
        }

        double middle = 0, low = 0, up = a, diff;
        while (low < up) {
            middle = (low + up) / 2.0;
            diff = middle * middle - a;
            if (Math.abs(diff) < epsilon) {
                return middle;
            }
            if (diff > 0) {
                up = middle;
            }
            else{
                low = middle;
            }
        }
        return middle;
    }

    public static double sqrtNewton(double a) {
        if (a < 0) {
            return Double.NaN;
        }
        double xn = a, diff = Math.pow(xn, 2) - a;
        while (Math.abs(diff) > epsilon) {
            xn = xn - (diff) / (2 * xn);
            diff = Math.pow(xn, 2) - a;
        }
        return xn;
    }

    public static void main(String[] args) {
        double v = MySqrt.sqrtUsingBST(6.25);
        System.out.println(v);
        double v1 = MySqrt.sqrtNewton(6.25);
        System.out.println(v1);

    }
}
