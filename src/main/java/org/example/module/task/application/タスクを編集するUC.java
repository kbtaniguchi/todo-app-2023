package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを編集するUC {
    final タスクリポジトリ型 タスクリポジトリ;

    @Transactional
    public void 実行する(タスク編集指示型 編集指示) {
        タスク記録 記録 = タスクリポジトリ.findById(編集指示.タスクID().value())
                .orElseThrow(IllegalArgumentException::new);
        記録.適用する(編集指示);
        タスクリポジトリ.save(記録);
    }
}
