package weblab3.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class HitCheckTest {

    @Test
    public void hitCheckNumberFormatExceptiion() {
        assertThrows(NumberFormatException.class, () -> {
            HitCheck.hitCheck(0d, 0d, 4.1);
        });
        assertThrows(NumberFormatException.class, () -> {
            HitCheck.hitCheck(0d, 0d, 0.99);
        });
        assertThrows(NumberFormatException.class, () -> {
            HitCheck.hitCheck(-5.1, 0d, 2d);
        });
        assertThrows(NumberFormatException.class, () -> {
            HitCheck.hitCheck(0d, 3.1, 2d);
        });
        assertThrows(NumberFormatException.class, () -> {
            HitCheck.hitCheck(0d, -5.1, 2d);
        });
    }

    @Test
    public void hitCheck() {
        assertTrue(HitCheck.hitCheck(0d, 0d, 2d));
    }

    @Test
    public void testHitCheckCircle() {
        assertTrue(HitCheck.hitCheck(0d, 0d, 2d));   // Попадание в круг при x = 0, y = 0, r = 2
        assertFalse(HitCheck.hitCheck(1d, 1d, 2d));  // Попадание в круг при x = 1, y = 1, r = 2
        assertFalse(HitCheck.hitCheck(-1d, -1d, 2d)); // Не попадание в круг при x = -1, y = -1, r = 2
    }

    @Test
    public void testHitCheckRectangle() {
        assertFalse(HitCheck.hitCheck(0.5, 0.5, 1d));   // Попадание в прямоугольник при x = 0.5, y = 0.5, r = 1
        assertTrue(HitCheck.hitCheck(-1d, -1d, 3d));  // Попадание в прямоугольник при x = -1, y = -1, r = 3
        assertFalse(HitCheck.hitCheck(3d, 3d, 2d));   // Не попадание в прямоугольник при x = 3, y = 3, r = 2
    }
}