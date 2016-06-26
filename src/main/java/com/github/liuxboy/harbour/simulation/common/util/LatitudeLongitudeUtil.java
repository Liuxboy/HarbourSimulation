package com.github.liuxboy.harbour.simulation.common.util;

import java.math.BigDecimal;

/**
 * <p>Title: LatitudeLongitudeUtil</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/26 12:32</p>
 * <p>Description: 经纬换算工具 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class LatitudeLongitudeUtil {

    //角度转为十进制
    public static double l2D(double degree, double minute, double second) {
        double result = degree + (minute + second / 60.0) / 60.0;
        return new BigDecimal(result).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(l2D(113, 12, 39.6));
    }
}
