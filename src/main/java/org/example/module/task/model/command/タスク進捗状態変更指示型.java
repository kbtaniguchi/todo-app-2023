package org.example.module.task.model.command;

import lombok.Getter;
import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスク進捗状態区分型;
import org.springframework.context.ApplicationEvent;

public record タスク進捗状態変更指示型(
        タスクID型 タスクID,
        バージョン型 バージョン,
        タスク進捗状態区分型 タスク進捗状態
) implements コマンド型<タスク記録型> {

    @Override
    public イベント型 実行する(タスク記録型 記録) {
        タスク記録型 実行前 = 記録.ディープコピーする();
        記録.進捗状態(タスク進捗状態.value());
        return new イベント型(記録, 実行前);
    }

    @Getter
    @ToString
    public static class イベント型 extends ApplicationEvent {
        タスク記録型 記録;
        タスク記録型 実行前;

        public イベント型(タスク記録型 記録, タスク記録型 実行前) {
            super(記録);
            this.記録 = 記録;
            this.実行前 = 実行前;
        }
    }
}
