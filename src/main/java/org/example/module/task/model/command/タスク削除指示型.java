package org.example.module.task.model.command;

import lombok.Getter;
import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.springframework.context.ApplicationEvent;

public record タスク削除指示型(
        タスクID型 タスクID,
        バージョン型 バージョン

) implements コマンド型<タスク記録型> {

    @Override
    public イベント型 実行する(タスク記録型 記録) {
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
