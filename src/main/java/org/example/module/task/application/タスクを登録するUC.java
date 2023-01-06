package org.example.module.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.framework.exception.業務例外型;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.rule.タスクポリシー型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクを登録するUC {
    final タスクリポジトリ型 タスクリポジトリ;
    final タスクポリシー型 タスクポリシー;

    @Transactional
    public タスク記録 実行する(タスク登録指示型 登録指示) {
        if (タスクポリシー.違反している()) throw new 業務例外型(タスクポリシー.違反メッセージ());
        タスク記録 記録 = new タスク記録();
        記録.適用する(登録指示);
        return タスクリポジトリ.save(記録);
    }
}
