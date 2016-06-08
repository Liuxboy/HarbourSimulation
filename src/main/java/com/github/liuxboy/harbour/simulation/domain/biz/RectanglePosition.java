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
    private Point LowerLeftCorner;
    //右上角坐标
    private Point UpperRightCorner;

    public Point getLowerLeftCorner() {
        return LowerLeftCorner;
    }

    public void setLowerLeftCorner(Point lowerLeftCorner) {
        LowerLeftCorner = lowerLeftCorner;
    }

    public Point getUpperRightCorner() {
        return UpperRightCorner;
    }

    public void setUpperRightCorner(Point upperRightCorner) {
        UpperRightCorner = upperRightCorner;
    }

    @Override
    public String toString() {
        return "RectanglePosition{" +
                "LowerLeftCorner=" + LowerLeftCorner +
                ", UpperRightCorner=" + UpperRightCorner +
                '}';
    }
}
