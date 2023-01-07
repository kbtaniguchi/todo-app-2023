package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.service.タスク検索サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを編集するUC {
    final タスクリポジトリ型 タスクリポジトリ;
    final タスク検索サービス型 タスク検索サービス;

    @Transactional
    public タスク記録型 実行する(タスク編集指示型 編集指示) {
        タスク記録型 記録 = タスク検索サービス.取得する(編集指示.タスクID());
        記録.適用する(編集指示);
        return タスクリポジトリ.save(記録);
    }
}
