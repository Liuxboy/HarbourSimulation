package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: ShipEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:23</p>
 * <p>Description: 锚地种类 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum AnchorageEnum {
    North(0, "北锚地"),
    South(1, "南锚地"),
    Ore(2, "矿石锚地"),
    Oil(3, "油轮锚地");
    private int typeCode;
    private String name;

    AnchorageEnum(int typeCode, String name) {
        this.typeCode = typeCode;
        this.name = name;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("AnchorageEnum{");
        stbd.append("\"typeCode\":").append(typeCode);
        stbd.append(",\"name\":\"").append(name).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
