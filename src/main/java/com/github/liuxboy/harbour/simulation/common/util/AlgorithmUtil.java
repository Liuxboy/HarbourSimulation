package com.github.liuxboy.harbour.simulation.common.util;

import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;

import java.math.BigDecimal;

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
    public static int possionSample(double λ) {
        PoissonDistribution poissonDistribution = new PoissonDistribution(λ);
        return poissonDistribution.sample();
    }
    public static int[] possionSamples(double λ, int n) {
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

    public static void main(String[] args) {
        //possion1();
        PoissonDistribution poissonDistribution = new PoissonDistribution(20.0d);
        int[] k = poissonDistribution.sample(1000);
        for (int i : k) {
            System.out.println(i);
        }
        NormalDistribution normalDistribution = new NormalDistribution();
    }
}
