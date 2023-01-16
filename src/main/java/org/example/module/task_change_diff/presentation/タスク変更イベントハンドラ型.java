package org.example.module.task_change_diff.presentation;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task_change_diff.application.タスクの変更差分を登録するUC;
import org.example.module.task_change_diff.model.command.タスク削除時変更記録指示型;
import org.example.module.task_change_diff.model.command.タスク登録時変更記録指示型;
import org.example.module.task_change_diff.model.command.タスク編集時変更記録指示型;
import org.example.module.task_change_diff.model.command.タスク進捗状態変更時変更記録指示型;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class タスク変更イベントハンドラ型 {

    final タスクの変更差分を登録するUC タスクの変更差分を登録する;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void 実行する(タスク登録指示型.イベント型 イベント) {
        タスク登録時変更記録指示型 コマンド = new タスク登録時変更記録指示型(イベント.記録());
        タスクの変更差分を登録する.実行する(コマンド);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void 実行する(タスク編集指示型.イベント型 イベント) {
        タスク編集時変更記録指示型 コマンド = new タスク編集時変更記録指示型(イベント.実行前(), イベント.記録());
        タスクの変更差分を登録する.実行する(コマンド);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void 実行する(タスク進捗状態変更指示型.イベント型 イベント) {
        タスク進捗状態変更時変更記録指示型 コマンド = new タスク進捗状態変更時変更記録指示型(イベント.実行前(), イベント.実行前());
        タスクの変更差分を登録する.実行する(コマンド);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void 実行する(タスク削除指示型.イベント型 イベント) {
        タスク削除時変更記録指示型 コマンド = new タスク削除時変更記録指示型(イベント.記録());
        タスクの変更差分を登録する.実行する(コマンド);
    }
}
