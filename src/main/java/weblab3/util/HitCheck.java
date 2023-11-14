package weblab3.util;

public class HitCheck {

    public static boolean hitCheck(Double x, Double y, Double r) {
        if (x < -5 || x > 5 || y < -5 || y > 3 || r < 1 || r > 4) {
            throw new NumberFormatException();
        }
        if (x <= 0 & y >= 0 & (x * x + y * y) <= r * r) {
            return true;
        } else if (x < 0 & y < 0 & y >= (-2 * x - r)) {
            return true;
        } else if (x > 0 & y < 0 & x <= r / 2 & y >= -r) {
            return true;
        } else {
            return false;
        }
    }


}
