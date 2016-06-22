package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.AnchorageEnum;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:04</p>
 * <p>Description: 锚地 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Anchorage {
    //编号
    private int id = 1;
    //类型
    private AnchorageEnum anchorageEnum;
    //左下角x
    private double lx;
    //左下角y
    private double ly;
    //右上角x
    private double ux;
    //右上角y
    private double uy;

    public AnchorageEnum getAnchorageEnum() {
        return anchorageEnum;
    }

    public void setAnchorageEnum(AnchorageEnum anchorageEnum) {
        this.anchorageEnum = anchorageEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLx() {
        return lx;
    }

    public void setLx(double lx) {
        this.lx = lx;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getUx() {
        return ux;
    }

    public void setUx(double ux) {
        this.ux = ux;
    }

    public double getUy() {
        return uy;
    }

    public void setUy(double uy) {
        this.uy = uy;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Anchorage{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"anchorageEnum\":").append(anchorageEnum);
        stbd.append(",\"lx\":").append(lx);
        stbd.append(",\"ly\":").append(ly);
        stbd.append(",\"ux\":").append(ux);
        stbd.append(",\"uy\":").append(uy);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
