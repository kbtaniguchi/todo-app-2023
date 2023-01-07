package org.example.module.task.model.command;

import org.example.framework.entity.コマンド型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;
import org.example.module.task.model.type.タスク進捗状態区分値;

public record タスク登録指示型(
        タスク名称型 タスク名称,
        タスクメモ型 タスクメモ
) implements コマンド型<タスク記録型> {

    @Override
    public void 編集する(タスク記録型 記録) {
        記録.名称(タスク名称.value());
        記録.メモ(タスクメモ.value());
        記録.進捗状態(タスク進捗状態区分値.TODO);
    }
}
