package org.example.module.task.model.command;

import lombok.ToString;
import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;
import org.example.module.task.model.type.タスク変更区分値;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record タスク編集指示型(
        タスクID型 タスクID,
        バージョン型 バージョン,
        タスク名称型 タスク名称,
        タスクメモ型 タスクメモ
) implements コマンド型<タスク記録型> {

    @Override
    public イベント型 実行する(タスク記録型 記録) {
        タスク記録型 実行前 = 記録.ディープコピーする();
        記録.名称(タスク名称.value());
        記録.メモ(タスクメモ.value());
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
            変更差分記録.変更区分(タスク変更区分値.編集);
            List<タスク変更差分記録型.明細型> 明細 = new ArrayList<>();
            if (!Objects.equals(実行前.名称(), 記録.名称()))
                明細.add(new タスク変更差分記録型.明細型()
                        .明細行番号(1)
                        .項目名("名称")
                        .変更前の値(実行前.名称())
                        .変更後の値(記録.名称()));
            if (!Objects.equals(実行前.メモ(), 記録.メモ()))
                明細.add(new タスク変更差分記録型.明細型()
                        .明細行番号(明細.size() + 1)
                        .項目名("メモ")
                        .変更前の値(実行前.メモ())
                        .変更後の値(記録.メモ()));
            if (!明細.isEmpty()) 変更差分記録.明細(明細);
            return 変更差分記録;
        }
    }
}
