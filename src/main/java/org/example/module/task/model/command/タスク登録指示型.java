package org.example.module.task.model.command;

import lombok.Getter;
import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;
import org.example.module.task.model.type.タスク進捗状態区分値;
import org.springframework.context.ApplicationEvent;

public record タスク登録指示型(
        タスク名称型 タスク名称,
        タスクメモ型 タスクメモ
) implements コマンド型<タスク記録型> {

    @Override
    public イベント型 実行する(タスク記録型 記録) {
        記録.名称(タスク名称.value());
        記録.メモ(タスクメモ.value());
        記録.進捗状態(タスク進捗状態区分値.TODO);
        return new イベント型(記録);
    }

    @Getter
    @ToString
    public static class イベント型 extends ApplicationEvent {
        タスク記録型 記録;

        public イベント型(タスク記録型 記録) {
            super(記録);
            this.記録 = 記録;
        }
    }
}
