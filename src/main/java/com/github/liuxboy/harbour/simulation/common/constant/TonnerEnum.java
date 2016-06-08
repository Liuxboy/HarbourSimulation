package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: TonnerEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/5 17:31</p>
 * <p>Description: 吨级 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum TonnerEnum {
    OneTon(0, "1万吨级"),
    TwoTon(1, "2万吨级"),
    FiveTon(2, "5万吨级"),
    TenTon(3, "10万吨级");
    private int typeCode;
    private String tonner;

    TonnerEnum(int typeCode, String tonner) {
        this.typeCode = typeCode;
        this.tonner = tonner;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getTonner() {
        return tonner;
    }

    public void setTonner(String tonner) {
        this.tonner = tonner;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("TonnerEnum{");
        stbd.append("\"tonner\":\"").append(tonner).append('\"');
        stbd.append("\"typeCode\":\"").append(typeCode).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
