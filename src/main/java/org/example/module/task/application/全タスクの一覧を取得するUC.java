package org.example.module.task.application;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.entity.タスク一覧型;
import org.example.module.task.model.service.タスク取得サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class 全タスクの一覧を取得するUC {
    final タスク取得サービス型 タスク検索サービス;

    public タスク一覧型 実行する() {
        return タスク検索サービス.全件取得する();
    }
}
