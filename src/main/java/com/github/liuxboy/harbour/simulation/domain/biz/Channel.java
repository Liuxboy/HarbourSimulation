package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.PassEnum;
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
public class Channel extends RectanglePosition {
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
    //通航模式
    private PassEnum passEnum;

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

    public PassEnum getPassEnum() {
        return passEnum;
    }

    public void setPassEnum(PassEnum passEnum) {
        this.passEnum = passEnum;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Channel{");
        stbd.append("\"id\":").append(id);
        stbd.append("\"width\":").append(width);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"limitedSpeed\":").append(limitedSpeed);
        stbd.append(",\"passEnum\":").append(passEnum);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
