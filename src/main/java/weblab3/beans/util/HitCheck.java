package weblab3.beans.util;

import weblab3.beans.models.Hit;

public class HitCheck {

    public static boolean hitCheck(Double x, Double y, Double r) {
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
