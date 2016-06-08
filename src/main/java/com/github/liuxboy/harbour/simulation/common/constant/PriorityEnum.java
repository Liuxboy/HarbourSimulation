package com.github.liuxboy.harbour.simulation.common.constant;

/**
 * <p>Title: PriorityEnum</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:37</p>
 * <p>Description: 优先级 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public enum PriorityEnum {
    High(0,"高优先级"),Normal(1, "一般优先级"),Low(2, "低优先级");
    private int priority;
    private String desc;

    PriorityEnum(int priority, String desc) {
        this.priority = priority;
        this.desc = desc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("PriorityEnum{");
        stbd.append("\"priority\":").append(priority);
        stbd.append(",\"desc\":\"").append(desc).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
