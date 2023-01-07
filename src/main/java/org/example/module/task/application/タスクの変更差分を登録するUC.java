package org.example.module.task.application;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.repository.タスク変更差分リポジトリ型;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class タスクの変更差分を登録するUC {
    final タスク変更差分リポジトリ型 タスク変更差分リポジトリ;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public タスク変更差分記録型 実行する(タスク登録指示型.イベント型 イベント) {
        タスク変更差分記録型 変更差分記録 = イベント.変更差分記録();
        return タスク変更差分リポジトリ.save(変更差分記録);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public タスク変更差分記録型 実行する(タスク編集指示型.イベント型 イベント) {
        タスク変更差分記録型 変更差分記録 = イベント.変更差分記録();
        return タスク変更差分リポジトリ.save(変更差分記録);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public タスク変更差分記録型 実行する(タスク進捗状態変更指示型.イベント型 イベント) {
        タスク変更差分記録型 変更差分記録 = イベント.変更差分記録();
        return タスク変更差分リポジトリ.save(変更差分記録);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public タスク変更差分記録型 実行する(タスク削除指示型.イベント型 イベント) {
        タスク変更差分記録型 変更差分記録 = イベント.変更差分記録();
        return タスク変更差分リポジトリ.save(変更差分記録);
    }
}
