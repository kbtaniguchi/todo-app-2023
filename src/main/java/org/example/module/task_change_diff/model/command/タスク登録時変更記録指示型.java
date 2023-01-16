package org.example.module.task_change_diff.model.command;

import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.example.module.task_change_diff.model.type.タスク変更区分値;

public record タスク登録時変更記録指示型(
        タスク記録型 登録記録
) implements タスク変更差分記録指示型 {

    @Override
    public タスク変更差分記録イベント型 実行する(タスク変更差分記録型 記録) {
        記録.taskId(登録記録.id())
                .changeType(タスク変更区分値.登録);
        return new タスク変更差分記録イベント型(記録);
    }
}
