package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.service.タスク取得サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを削除するUC {
    final タスクリポジトリ型 タスクリポジトリ;
    final タスク取得サービス型 タスク検索サービス;

    @Transactional
    public void 実行する(タスク削除指示型 削除指示) {
        タスク記録型 記録 = タスク検索サービス.取得する(削除指示.タスクID());
        記録.適用する(削除指示);
        タスクリポジトリ.delete(記録);
    }
}
