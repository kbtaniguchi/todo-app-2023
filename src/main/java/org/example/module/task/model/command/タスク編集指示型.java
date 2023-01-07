package org.example.module.task.model.command;

import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;

public record タスク編集指示型(
        タスクID型 タスクID,
        バージョン型 バージョン,
        タスク名称型 タスク名称,
        タスクメモ型 タスクメモ
) implements コマンド型<タスク記録型> {

    @Override
    public void 編集する(タスク記録型 記録) {
        記録.名称(タスク名称.value());
        記録.メモ(タスクメモ.value());
    }
}
