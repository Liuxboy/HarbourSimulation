package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/7/1 1:05</p>
 * <p>Description: 船长枚举 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum LengthEnum {
    Ton1_3("1.3吨", 100, 150, 0.1065),
    Ton3_0("3.0吨", 150, 200, 0.6341),
    Ton5_3("5.3吨", 200, 250, 0.1198),
    Ton8_6("8.6吨", 250, 300, 0.3255),
    Ton15_6("15.6吨", 350, 400, 0.1779),
    Ton15_3("15.3吨", 400, 150, 0.0811);
    private String tonner;      //吨位
    private int lowLength;      //区间低点
    private int highLength;     //区间高点
    private double proportion;  //所占比例

    LengthEnum(String tonner, int lowLength, int highLength, double proportion) {
        this.tonner = tonner;
        this.lowLength = lowLength;
        this.highLength = highLength;
        this.proportion = proportion;
    }

    public String getTonner() {
        return tonner;
    }

    public void setTonner(String tonner) {
        this.tonner = tonner;
    }

    public int getLowLength() {
        return lowLength;
    }

    public void setLowLength(int lowLength) {
        this.lowLength = lowLength;
    }

    public int getHighLength() {
        return highLength;
    }

    public void setHighLength(int highLength) {
        this.highLength = highLength;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "LengthEnum{" +
                "tonner='" + tonner + '\'' +
                ", lowLength=" + lowLength +
                ", highLength=" + highLength +
                ", proportion=" + proportion +
                '}';
    }
}
