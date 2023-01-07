package org.example.module.task.application;

import lombok.RequiredArgsConstructor;
import org.example.framework.entity.イベント型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.repository.タスク変更差分リポジトリ型;
import org.example.module.task.model.rule.タスク変更差分ファクトリー型;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class タスクの変更差分を登録するUC {
    final タスク変更差分ファクトリー型 タスク変更差分ファクトリー;
    final タスク変更差分リポジトリ型 タスク変更差分リポジトリ;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public タスク変更差分記録型 実行する(イベント型<タスク記録型> イベント) {
        タスク変更差分記録型 記録 = タスク変更差分ファクトリー.作成する(イベント);
        return タスク変更差分リポジトリ.save(記録);
    }
}
