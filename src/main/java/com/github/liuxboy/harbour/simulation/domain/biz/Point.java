package com.github.liuxboy.harbour.simulation.domain.biz;

/**
 * <p>Title: Point</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/7 18:51</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Point {
    //x坐标
    private double x;
    //y坐标
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Point{");
        stbd.append("\"x\":").append(x);
        stbd.append(",\"y\":").append(y);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
