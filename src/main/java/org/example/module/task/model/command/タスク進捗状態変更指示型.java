package org.example.module.task.model.command;

import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスク変更区分値;
import org.example.module.task.model.type.タスク進捗状態区分型;
import org.springframework.context.ApplicationEvent;

import java.util.Collections;

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

    @ToString
    public static class イベント型 extends ApplicationEvent {
        タスク記録型 記録;
        タスク記録型 実行前;

        public イベント型(タスク記録型 記録, タスク記録型 実行前) {
            super(記録);
            this.記録 = 記録;
            this.実行前 = 実行前;
        }

        public タスク変更差分記録型 変更差分記録() {
            タスク変更差分記録型 変更差分記録 = new タスク変更差分記録型()
                    .タスクID(記録.id());
            変更差分記録.変更区分(タスク変更区分値.進捗状態変更);
            タスク変更差分記録型.明細型 明細 = new タスク変更差分記録型.明細型()
                    .明細行番号(1)
                    .項目名("進捗状態")
                    .変更前の値(実行前.進捗状態().toString())
                    .変更後の値(記録.進捗状態().toString());
            変更差分記録.明細(Collections.singletonList(明細));
            return 変更差分記録;
        }
    }
}
