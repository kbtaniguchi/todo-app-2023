package org.example.module.task_change_diff.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.module.task_change_diff.model.command.タスク変更差分記録指示型;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.example.module.task_change_diff.model.repository.タスク変更差分リポジトリ型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクの変更差分を登録するUC {
    final タスク変更差分リポジトリ型 タスク変更差分リポジトリ;

    @Transactional
    public タスク変更差分記録型 実行する(タスク変更差分記録指示型 記録指示) {
        タスク変更差分記録型 記録 = new タスク変更差分記録型();
        記録.適用する(記録指示);
        return タスク変更差分リポジトリ.save(記録);
    }
}
