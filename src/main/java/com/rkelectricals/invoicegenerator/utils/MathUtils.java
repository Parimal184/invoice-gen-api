package com.rkelectricals.invoicegenerator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {
	
    public static Double format(Double value) {
    	BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
}
