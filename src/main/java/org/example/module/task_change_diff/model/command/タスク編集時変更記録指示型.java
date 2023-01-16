package org.example.module.task_change_diff.model.command;

import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.example.module.task_change_diff.model.type.タスク変更区分値;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record タスク編集時変更記録指示型(
        タスク記録型 編集前記録,
        タスク記録型 編集後記録
) implements タスク変更差分記録指示型 {

    @Override
    public タスク変更差分記録イベント型 実行する(タスク変更差分記録型 記録) {
        記録.taskId(編集前記録.id())
                .changeType(タスク変更区分値.編集);
        List<タスク変更差分記録型.明細> 明細 = new ArrayList<>();
        if (!Objects.equals(編集前記録.名称(), 編集後記録.名称()))
            明細.add(new タスク変更差分記録型.明細()
                    .lineNumber(1)
                    .fieldName("名称")
                    .beforeValue(編集前記録.名称())
                    .afterValue(編集後記録.名称()));
        if (!Objects.equals(編集前記録.メモ(), 編集後記録.メモ()))
            明細.add(new タスク変更差分記録型.明細()
                    .lineNumber(明細.size() + 1)
                    .fieldName("メモ")
                    .beforeValue(編集前記録.メモ())
                    .afterValue(編集後記録.メモ()));
        if (!明細.isEmpty()) 記録.details(明細);
        return new タスク変更差分記録イベント型(記録);
    }
}
