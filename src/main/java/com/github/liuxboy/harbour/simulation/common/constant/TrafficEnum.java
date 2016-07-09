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
    CS_PROHIBIT_ANCHOR(0, "集装箱船靠泊管制", "大风"),
    BBS_PROHIBIT_ANCHOR(1, "散杂货船靠泊管制", "大风"),
    DANGER_PROHIBIT_ANCHOR(2, "危险品船靠泊管制", "大风"),
    PROHIBIT_BOTH_TRAVEL_BAD_VISIBILITY(3, "航行管制", "能见度不良"),
    PROHIBIT_CONTRARY_TRAVEL(4, "单向航行管制", "特殊船舶通航"),
    PROHIBIT_BOTH_TRAVEL_FISH_BOAT_BLOCK(5, "航行管制", "渔船阻碍"),
    PROHIBIT_BOTH_TRAVEL_ACCIDENT(6, "航行管制", "事故险情");

    private int typeCode;
    private String type;
    private String reason;

    TrafficEnum(int typeCode, String type, String reason) {
        this.typeCode = typeCode;
        this.type = type;
        this.reason = reason;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TrafficEnum{" +
                "typeCode=" + typeCode +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
