package org.example.module.task_change_diff.application;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task_change_diff.model.entity.タスク変更差分一覧型;
import org.example.module.task_change_diff.model.service.タスク変更差分取得サービス型;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class タスクの変更差分の一覧を取得するUC {
    final タスク変更差分取得サービス型 タスク変更差分検索サービス;

    public タスク変更差分一覧型 実行する(タスクID型 タスクID) {
        return タスク変更差分検索サービス.取得する(タスクID);
    }
}
