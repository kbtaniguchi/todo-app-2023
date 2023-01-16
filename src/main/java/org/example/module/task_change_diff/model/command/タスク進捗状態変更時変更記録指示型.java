package org.example.module.task_change_diff.model.command;

import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.example.module.task_change_diff.model.type.タスク変更区分値;

import java.util.Collections;

public record タスク進捗状態変更時変更記録指示型(
        タスク記録型 編集前記録,
        タスク記録型 編集後記録
) implements タスク変更差分記録指示型 {

    @Override
    public タスク変更差分記録イベント型 実行する(タスク変更差分記録型 記録) {
        記録.taskId(編集後記録.id())
                .changeType(タスク変更区分値.進捗状態変更);
        タスク変更差分記録型.明細 明細 = new タスク変更差分記録型.明細()
                .lineNumber(1)
                .fieldName("進捗状態")
                .beforeValue(編集前記録.進捗状態().toString())
                .afterValue(編集後記録.進捗状態().toString());
        記録.details(Collections.singletonList(明細));
        return new タスク変更差分記録イベント型(記録);
    }
}
