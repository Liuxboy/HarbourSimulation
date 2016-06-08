package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * Created by jixing on 2016/6/13.
 */
public enum TrafficEnum {
    PROHIBIT_ANCHOR(0, "禁止停靠"),
    PROHIBIT_CONTRARY_TRAVEL(1, "不允许对向行船"),
    PROHIBIT_SAME_TRAVEL(2, "不允许同向行船");

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
