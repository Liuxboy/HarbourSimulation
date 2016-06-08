package com.github.liuxboy.harbour.simulation.common.util;

/**
 * <p>Title: PassEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:14</p>
 * <p>Description: 通航模式枚举 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum PassEnum {
    OneWay(0, "单向"),
    BothWay(1, "双向");
    private int typeCode;
    private String pattern;

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    PassEnum(int typeCode, String pattern) {
        this.typeCode = typeCode;
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("PassEnum{");
        stbd.append("\"typeCode\":\"").append(typeCode).append('\"');
        stbd.append("\"pattern\":\"").append(pattern).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
