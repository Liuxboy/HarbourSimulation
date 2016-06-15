package com.github.liuxboy.harbour.simulation.domain.biz;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/13 22:18</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class RectanglePosition {
    //左下角坐标
    private Point lowerLeftCorner;
    //右上角坐标
    private Point upperRightCorner;

    public Point getLowerLeftCorner() {
        return lowerLeftCorner;
    }

    public void setLowerLeftCorner(Point lowerLeftCorner) {
        this.lowerLeftCorner = lowerLeftCorner;
    }

    public Point getUpperRightCorner() {
        return upperRightCorner;
    }

    public void setUpperRightCorner(Point upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
    }

    @Override
    public String toString() {
        return "RectanglePosition{" +
                "lowerLeftCorner=" + lowerLeftCorner +
                ", upperRightCorner=" + upperRightCorner +
                '}';
    }
}
