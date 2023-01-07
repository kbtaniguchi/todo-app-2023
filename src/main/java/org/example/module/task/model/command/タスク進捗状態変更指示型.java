package org.example.module.task.model.command;

import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスク進捗状態型;

public record タスク進捗状態変更指示型(
        タスクID型 タスクID,
        バージョン型 バージョン,
        タスク進捗状態型 タスク進捗状態
) implements コマンド型<タスク記録型> {

    @Override
    public void 編集する(タスク記録型 記録) {
        記録.進捗状態(タスク進捗状態.value());
    }
}
