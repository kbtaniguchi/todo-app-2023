package org.example.module.task.model.service;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.payload.outbound.タスク検索結果型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.type.タスクID型;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class タスク検索サービス型 {
    final タスクリポジトリ型 タスクリポジトリ;

    public タスク記録 取得する(タスクID型 id) {
        return タスクリポジトリ.findById(id.value())
                .orElseThrow(IllegalArgumentException::new);
    }

    public タスク検索結果型 全件取得する() {
        List<タスク記録> 全件 = タスクリポジトリ.findAll();
        return new タスク検索結果型(全件);
    }
}
