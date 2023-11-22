package weblab3.util;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Decimalise {

    public static Double decimalise(Double value) throws ParseException {
        return Math.round( value * 100.0 ) / 100.0;
    }

}
