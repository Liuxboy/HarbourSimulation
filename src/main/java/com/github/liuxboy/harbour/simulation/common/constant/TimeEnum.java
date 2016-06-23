package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: TimeEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/24 00:55</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum TimeEnum {
    YEA(31536000, "年"),
    MON(2592000, "月"),
    WEK(604800, "周"),
    DAY(86400, "天"),
    HOR(3600, "时"),
    MIN(60, "分"),
    SEC(1, "秒");
    private long time;
    private String unit;

    TimeEnum(long time, String unit) {
        this.time = time;
        this.unit = unit;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("TimeEnum{");
        stbd.append("\"time\":").append(time);
        stbd.append(",\"unit\":\"").append(unit).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
