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
    Crude_Oil(0, "原油", 0.0472),
    Iron_Ore(1, "铁矿石", 0.0766),
    Coal(2, "煤炭", 0.0291),
    Container_Ship(3, "集装箱船", 0.7525),
    Chemical_Oil(4, "化工油品", 0.0745),
    Break_Bulk_Ship(5, "散杂船", 0.203);
    private int typeCode;       //编号
    private String nameCN;      //名称
    private double proportion;  //每天到达所占比例

    ShipEnum(int typeCode, String nameCN, double proportion) {
        this.typeCode = typeCode;
        this.nameCN = nameCN;
        this.proportion = proportion;
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

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("ShipEnum{");
        stbd.append("\"typeCode\":\"").append(typeCode).append('\"');
        stbd.append("\"nameCN\":\"").append(nameCN).append('\"');
        stbd.append("\"proportion\":\"").append(proportion).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
