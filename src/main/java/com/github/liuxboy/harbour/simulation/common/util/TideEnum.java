package com.github.liuxboy.harbour.simulation.common.util;

/**
 * <p>Title: TideEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/5 17:34</p>
 * <p>Description: 潮水变化 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum TideEnum {
    Rising(0, "潮涨"),
    Falling(1, "潮落");
    private int tide;
    private String desc;

    TideEnum(int tide, String desc) {
        this.tide = tide;
        this.desc = desc;
    }

    public int getTide() {
        return tide;
    }

    public void setTide(int tide) {
        this.tide = tide;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("TideEnum{");
        stbd.append("\"tide\":").append(tide);
        stbd.append(",\"desc\":\"").append(desc).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
