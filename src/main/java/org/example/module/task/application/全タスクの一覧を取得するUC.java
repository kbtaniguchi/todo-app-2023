package org.example.module.task.application;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.payload.outbound.タスク検索結果型;
import org.example.module.task.model.service.タスク検索サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class 全タスクの一覧を取得するUC {
    final タスク検索サービス型 タスク検索サービス;

    public タスク検索結果型 実行する() {
        return タスク検索サービス.全件取得する();
    }
}
