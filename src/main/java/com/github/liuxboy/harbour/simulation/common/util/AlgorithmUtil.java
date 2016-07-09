package com.github.liuxboy.harbour.simulation.common.util;

import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: AlgorithmUtil</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 15:04</p>
 * <p>Description: 算法 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class AlgorithmUtil {
    /**
     * http://smilejay.com/2013/05/possion-number-in-c-language/
     */
    public static void possion1() {
        int num = 1000; //产生随机数的个数
        int lamda = 20; //lamda值
        for (int i = 0; i < num; i++) {
            BigDecimal p0 = new BigDecimal(Math.exp(-lamda));
            int k = 0;
            while (true) {
                double randValue = Math.random();
                if (p0.doubleValue() > randValue)
                    break;
                else {
                    p0 = p0.multiply(new BigDecimal(1.0 * lamda / (k + 1)));
                    k++;
                    //System.out.println(randValue);
                }
                if (k >= 3 * lamda)//防止找不到的情况
                {
                    k = 0;
                    p0 = new BigDecimal(Math.exp(-lamda));
                }
                //System.out.println("--------------");
            }
            System.out.println(i + " : " + k);
        }
    }

    //泊松分布，λ为平均值
    public static int poissonSample(double λ) {
        PoissonDistribution poissonDistribution = new PoissonDistribution(λ);
        return poissonDistribution.sample();
    }

    public static int[] poissonSamples(double λ, int n) {
        PoissonDistribution poissonDistribution = new PoissonDistribution(λ);
        return poissonDistribution.sample(n);
    }

    //正态分布，μ为平均值(mean)，σ为标准差-sd(standard deviation)
    public static double normalSample(double μ, double σ) {
        NormalDistribution normalDistribution = new NormalDistribution(μ, σ);
        return normalDistribution.sample();
    }

    public static double[] normalSamples(double μ, double σ, int num) {
        NormalDistribution normalDistribution = new NormalDistribution(μ, σ);
        return normalDistribution.sample(num);
    }

    //对数正态分布
    //On a logarithmic scale, can be called the location parameter and the scale parameter,
    public static double logNormalSample(double scale, double shape) {
        LogNormalDistribution logNormalDistribution = new LogNormalDistribution(scale, shape);
        return logNormalDistribution.sample();
    }

    public static double[] logNormalSamples(double scale, double shape, int num) {
        LogNormalDistribution logNormalDistribution = new LogNormalDistribution(scale, shape);
        return logNormalDistribution.sample(num);
    }

    //求对数
    public static double log(double base, double value) {
        return Math.log(value) / Math.log(base);
    }

    //求指数的底数
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /*private static int getMonthDays(int month) {
        switch (month) {
            case 2:
                return 29;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 30;
    }*/

    public static void main(String[] args) {
        //int i = 8;
        //System.out.println(i + "月有" + getMonthDays(i) + "天");
        /*
        int simulationDays = 1;
        int[] simulationShipArray = AlgorithmUtil.poissonSamples(36.0193 / (24.0 * 60.0), 24 * 60 * simulationDays);
        int n = 0, m = 0;
        for (int step = 1; step < simulationShipArray.length + 1; step++) {
            if (simulationShipArray[step - 1] == 1) {
                n++;
                System.out.println("step=" + step);
                System.out.println("n=" + n);
            }
            if (simulationShipArray[step - 1] > 1) {
                m++;
                System.out.println("ships=" + simulationShipArray[step - 1]);
                System.out.println("m=" + m);
            }
        }
        System.out.println("m=" + m);*/

        /*double[] lengths = AlgorithmUtil.normalSamples(259.4, 100, 8000);
        for (double d : lengths) {
            System.out.println(d);
        }*/

        /*System.out.println(log(2.0, 8.0));
        System.out.println(power(279.4 / 3.6221, 1.0 / 0.3898));
        double tonner = 170000.0;
        //非货运船，小于万吨
        if (tonner < 10000) {
            System.out.println("小于1万吨"+normalSample(9.0, 2));
        } else if (tonner < 50000) {
            System.out.println("小于5万吨"+normalSample(11.0, 1));
        } else if (tonner < 100000) {
            System.out.println("小于10万吨"+normalSample(14.0, 2));
        } else if (tonner < 150000) {
            System.out.println("小于15万吨"+normalSample(17, 1));
        } else {
            System.out.println("其他"+normalSample(20, 2));
        }
        System.out.println(COLOR.values()[0]);*/
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        String str = map.get(1);
        map.remove(1);
        map.put(4,str);
        System.out.println(map);
    }

    static enum COLOR {
        RED(0,"红色"),
        GREEN(1, "绿色");
        private int code;
        private String desc;

        COLOR(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "COLOR{" +
                    "code=" + code +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }
}
