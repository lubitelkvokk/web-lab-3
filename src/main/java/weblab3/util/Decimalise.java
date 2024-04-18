package weblab3.util;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Decimalise {

    /**
     * Округление числа до 2 знаков после запятой
     * @param value
     * @return
     * @throws ParseException
     */
    public static Double decimalise(Double value) throws ParseException {
        return Math.round( value * 100.0 ) / 100.0;
    }

}
