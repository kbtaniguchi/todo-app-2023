package org.example.module.task.model.command;

import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;
import org.example.module.task.model.type.タスク変更区分値;
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

    @ToString
    public static class イベント型 extends ApplicationEvent {
        タスク記録型 記録;

        public イベント型(タスク記録型 記録) {
            super(記録);
            this.記録 = 記録;
        }

        public タスク変更差分記録型 変更差分記録() {
            タスク変更差分記録型 変更差分記録 = new タスク変更差分記録型()
                    .タスクID(記録.id());
            変更差分記録.変更区分(タスク変更区分値.登録);
            return 変更差分記録;
        }
    }
}
