package org.example.module.task_change_diff.model.service;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task_change_diff.model.entity.タスク変更差分一覧型;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.example.module.task_change_diff.model.repository.タスク変更差分リポジトリ型;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class タスク変更差分取得サービス型 {
    final タスク変更差分リポジトリ型 タスク変更差分リポジトリ;

    public タスク変更差分一覧型 取得する(タスクID型 id) {
        List<タスク変更差分記録型> list = タスク変更差分リポジトリ.findByTaskId(id.value());
        return new タスク変更差分一覧型(list);
    }
}
