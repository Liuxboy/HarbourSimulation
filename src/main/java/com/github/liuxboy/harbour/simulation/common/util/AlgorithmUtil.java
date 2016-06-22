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
    //泊松分布
    public static int possionSample(double mean) {
        PoissonDistribution poissonDistribution = new PoissonDistribution(20.0d);
        return poissonDistribution.sample();
    }
    public static int[] possionSamples(double mean, int num) {
        PoissonDistribution poissonDistribution = new PoissonDistribution(20.0d);
        return poissonDistribution.sample(num);
    }
    //正态分布
    public static double normalSample(double mean, double division) {
        NormalDistribution normalDistribution = new NormalDistribution(mean, division);
        return normalDistribution.sample();
    }
    public static double[] normalSamples(double mean, double division, int num) {
        NormalDistribution normalDistribution = new NormalDistribution(mean, division);
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
