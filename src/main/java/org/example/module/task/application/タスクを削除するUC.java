package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを削除するUC {
    final タスクリポジトリ型 タスクリポジトリ;

    @Transactional
    public void 実行する(タスク削除指示型 削除指示) {
        タスク記録 記録 = タスクリポジトリ.findById(削除指示.タスクID().value())
                .orElseThrow(IllegalArgumentException::new);
        記録.適用する(削除指示);
        タスクリポジトリ.delete(記録);
    }
}
