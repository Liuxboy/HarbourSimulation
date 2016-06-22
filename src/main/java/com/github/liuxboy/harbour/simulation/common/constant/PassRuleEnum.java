package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: PassDirectEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:14</p>
 * <p>Description: 通航规则枚举 </p>
 *（1.1）先干线，后支线；先航道后锚地，确保航道通畅。适当控制锚地船舶的起锚时间，防止出现交通流密度过大导致拥堵；（即优先安排在深水航道的船进入，然后安排在锚地的船舶进入）
 *（1.2）正常以船舶到L1报告线的ETA(Estimated Time of Arrival)或引水上船时间先后顺序安排进口，当有两艘或两艘以上的船舶ETA(Estimated Time of Arrival)或者引水上船时间相同时，
 * 则根据各船实际位置，离口门较近或者航速较快的优先安排进口，并尽早告知各船其在编队中的位置；（按照到港时间的先后顺序安排进港，如时间相同则安排离口较近或航速较快的船舶优先进入航道）
 *（1.3）VLCC（油轮）、超大型矿船等船舶因操纵不便，其进口时其他船舶不得妨碍；（即油轮和超大型船在进口时不允许其他船舶在该时刻进入）
 *（1.4）煤炭、天然气等重要保障资源船舶优先。（液化气船具有优先进入权）
 * @author wyliuchundong
 * @version 1.0
 */
public enum PassRuleEnum {
    First_Main_Second_Branch(0, "优先安排在深水航道的船进入，然后安排在锚地的船舶进入"),
    Normal(1, "按照到港时间的先后顺序安排进港，如时间相同则安排离口较近或航速较快的船舶优先进入航道"),
    VLCC(2, "油轮和超大型船在进口时不允许其他船舶在该时刻进入"),
    Coal_Gas(3, "液化气船具有优先进入权");

    private int typeCode;
    private String desc;

    PassRuleEnum(int typeCode, String desc) {
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
        final StringBuilder stbd = new StringBuilder("PassRuleEnum{");
        stbd.append("\"typeCode\":").append(typeCode);
        stbd.append(",\"desc\":\"").append(desc).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
