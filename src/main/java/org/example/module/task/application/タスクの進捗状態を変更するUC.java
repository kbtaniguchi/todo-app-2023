package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクの進捗状態を変更するUC {
    final タスクリポジトリ型 タスクリポジトリ;

    @Transactional
    public void 実行する(タスク進捗状態変更指示型 進捗状態変更指示) {
        タスク記録 記録 = タスクリポジトリ.findById(進捗状態変更指示.タスクID().value())
                .orElseThrow(IllegalArgumentException::new);
        記録.適用する(進捗状態変更指示);
        タスクリポジトリ.save(記録);
    }
}
