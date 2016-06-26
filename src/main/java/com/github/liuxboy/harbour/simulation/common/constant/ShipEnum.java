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
    Crude_Oil(0, "原油"),
    Iron_Ore(1, "铁矿石"),
    Coal(2, "煤炭"),
    Container_Ship(3, "集装箱船"),
    Chemical_Oil(4, "化工油品"),
    Break_Bulk_Ship(5, "散杂船");
    private int typeCode;
    private String nameCN;

    ShipEnum() {
    }

    ShipEnum(int typeCode, String nameCN) {
        this.typeCode = typeCode;
        this.nameCN = nameCN;
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

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("ShipEnum{");
        stbd.append("\"typeCode\":\"").append(typeCode).append('\"');
        stbd.append("\"nameCN\":\"").append(nameCN).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
