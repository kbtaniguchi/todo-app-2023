package org.example.module.task.model.type;

public record タスク名称型(String value) {
    public static final int 最小桁数 = 1;
    public static final int 最大桁数 = 255;
}
