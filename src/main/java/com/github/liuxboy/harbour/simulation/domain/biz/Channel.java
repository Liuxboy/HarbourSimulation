package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.PassDirectEnum;
import org.springframework.stereotype.Component;

/**
 * <p>Title: Channel</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:04</p>
 * <p>Description: 航道 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Component
public class Channel {
    //编号
    private int id = 1;
    //宽度
    private int width;
    //长度
    private int length;
    //深度
    private int depth;
    //限速
    private float limitedSpeed;
    //左下角坐标x
    private double lx;
    //左下角坐标y
    private double ly;
    //右上角坐标x
    private double ux;
    //右上角坐标y
    private double uy;
    //通航模式
    private PassDirectEnum passEnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getLimitedSpeed() {
        return limitedSpeed;
    }

    public void setLimitedSpeed(float limitedSpeed) {
        this.limitedSpeed = limitedSpeed;
    }

    public PassDirectEnum getPassEnum() {
        return passEnum;
    }

    public void setPassEnum(PassDirectEnum passEnum) {
        this.passEnum = passEnum;
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
        final StringBuilder stbd = new StringBuilder("Channel{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"width\":").append(width);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"limitedSpeed\":").append(limitedSpeed);
        stbd.append(",\"lx\":").append(lx);
        stbd.append(",\"ly\":").append(ly);
        stbd.append(",\"ux\":").append(ux);
        stbd.append(",\"uy\":").append(uy);
        stbd.append(",\"passEnum\":").append(passEnum);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
