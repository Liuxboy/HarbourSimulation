package com.github.liuxboy.harbour.simulation.domain.biz;

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
public class Anchorage extends RectanglePosition {
    //编号
    private int id;
    //类型
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Anchorage{");
        stbd.append("\"id\":").append(id);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
