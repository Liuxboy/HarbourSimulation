package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: TonnerEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/5 17:31</p>
 * <p>Description: 交通管制 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum TrafficEnum {
    CS_PROHIBIT_ANCHOR(0, "集装箱船靠泊管制"),
    BBS_PROHIBIT_ANCHOR(1, "散杂货船靠泊管制"),
    DANGER_PROHIBIT_ANCHOR(2, "危险品船靠泊管制"),
    PROHIBIT_BOTH_TRAVEL(3, "航行管制"),
    PROHIBIT_CONTRARY_TRAVEL(4, "单向航行管制");

    private int typeCode;
    private String desc;

    TrafficEnum(int typeCode, String desc) {
        this.typeCode = typeCode;
        this.desc = desc;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TrafficEnum{" +
                "typeCode=" + typeCode +
                ", desc='" + desc + '\'' +
                '}';
    }
}
