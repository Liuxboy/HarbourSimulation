package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: ShipEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:23</p>
 * <p>Description: 船舶种类 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum ShipEnum {
    Crude_oil(0, "原油","Very Large Crude Carrier"),
    Coal(1, "煤炭", "Liquefied Petroleum Gas"),
    LNG(2, "铁矿石", "Liquefied Natural Gas"),
    Iron_Ore(3, "集装箱船"," Container Ship"),
    CC(4, "化工油品", "Chemical Carrier"),
    BBS(5, "散杂船", "Break Bulk Ship");
    private int typeCode;
    private String nameCN;
    private String nameEn;

    ShipEnum(int typeCode, String nameCN, String nameEn) {
        this.typeCode = typeCode;
        this.nameCN = nameCN;
        this.nameEn = nameEn;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("ShipEnum{");
        stbd.append("\"typeCode\":\"").append(typeCode).append('\"');
        stbd.append("\"nameCN\":\"").append(nameCN).append('\"');
        stbd.append(",\"nameEn\":\"").append(nameEn).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
