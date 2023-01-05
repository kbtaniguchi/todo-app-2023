package org.example.module.task.application;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.type.タスクID型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを取得するUC {
    final タスクリポジトリ型 タスクリポジトリ;

    public タスク記録 実行する(タスクID型 タスクID) {
        return タスクリポジトリ.findById(タスクID.value())
                .orElseThrow(IllegalArgumentException::new);
    }
}
