package com.github.liuxboy.harbour.simulation.common.constant;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author wyliuchundong
 * @version 1.0.0
 * @date 2015/4/5 11:19
 * @comment BigDecimalUtil
 */
public class BigDecimalUtil {

    /**
     * 两个BigDecimal相除，四舍五入保留两位小数
     * @param dividend
     * @param divisor
     * @return
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        if (dividend == null || divisor == null) {
            return null;
        }
        return dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_DOWN);
    }

    /**
     * 将一个BigDecimal数以四舍五入的方式保留2位，然后转换成String
     *
     * @param bigDecimal
     *
     * @return
     */
    public static String decimal2String(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString() : "--";
    }

    /**
     * 将一个double数以四舍五入的方式保留2位，然后转换成String
     *
     * @param var
     *
     * @return
     */
    public static String decimal2String(Double var) {
        if (var != null) {
            BigDecimal bigDecimal = new BigDecimal(var).setScale(2, BigDecimal.ROUND_HALF_UP);
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(bigDecimal);
        }
        return "0.00";
    }
    /**
     * 将一个double取掉小数位，然后转换成String
     *
     * @param var
     *
     * @return
     */
    public static String decimalNoPoint(Double var) {
        if (var != null) {
            Long bigDecimal = new BigDecimal(var).longValue();
            return bigDecimal.toString();
        }
        return "--";
    }

    /**
     * 将一个double数以四舍五入的方式保留2位
     *
     * @param var
     *
     * @return
     */
    public static double decimal2Double(Double var) {
        if (var != null) {
            return new BigDecimal(var).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return 0.0D;
    }

    /**
     * 将一个float数以四舍五入的方式保留2位
     *
     * @param var
     *
     * @return
     */
    public static float decimal2Float(Float var) {
        if (var != null) {
            return new BigDecimal(var).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        }
        return 0.0F;
    }

    public static Long str2Long(String va1) {
        return NumberUtils.isNumber(va1) ? Long.parseLong(va1) : null;
    }

    public static long str2long(String va1) {
        return NumberUtils.isNumber(va1) ? Long.parseLong(va1) : 0L;
    }

    public static void main(String[] args) {
        double var = -0.0178;
        BigDecimal bigDecimal = new BigDecimal(var);
        System.out.println(divide(new BigDecimal(89), new BigDecimal(90)).movePointRight(2).intValue());
        System.out.println(decimal2String(0.0001d * 100));
        System.out.println(decimal2Double(0.10));
        System.out.println(decimal2Float(0.10F));
        System.out.println(decimal2String(var));
        System.out.println(decimal2String(bigDecimal));
        System.out.println(decimalNoPoint(1233556565.5665));
    }
}
