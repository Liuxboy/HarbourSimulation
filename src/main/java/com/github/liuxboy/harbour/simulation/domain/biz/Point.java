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
    private int x;
    //y坐标
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
