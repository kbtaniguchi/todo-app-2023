package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.service.タスク取得サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクの進捗状態を変更するUC {
    final タスクリポジトリ型 タスクリポジトリ;
    final タスク取得サービス型 タスク検索サービス;

    @Transactional
    public タスク記録型 実行する(タスク進捗状態変更指示型 進捗状態変更指示) {
        タスク記録型 記録 = タスク検索サービス.取得する(進捗状態変更指示.タスクID());
        記録.適用する(進捗状態変更指示);
        return タスクリポジトリ.save(記録);
    }
}
