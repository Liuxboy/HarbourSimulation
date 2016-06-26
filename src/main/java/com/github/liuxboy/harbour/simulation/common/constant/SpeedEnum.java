package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: SpeedEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/26 07:24</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum SpeedEnum {
    Knot(0, "1节", "海里/时", 0.51444),
    Kilo(1, "1公里", "公里/时", 0.27000);
    private int typeCode;
    private String shortDesc;
    private String desc;
    private double speed;   //米/秒即m/s

    SpeedEnum(int typeCode, String shortDesc, String desc, double speed) {
        this.typeCode = typeCode;
        this.shortDesc = shortDesc;
        this.desc = desc;
        this.speed = speed;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("SpeedEnum{");
        stbd.append("\"typeCode\":").append(typeCode);
        stbd.append(",\"shortDesc\":\"").append(shortDesc).append('\"');
        stbd.append(",\"desc\":\"").append(desc).append('\"');
        stbd.append(",\"speed\":").append(speed);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
