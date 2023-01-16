package org.example.module.task.model.service;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.entity.タスク一覧型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.type.タスクID型;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class タスク取得サービス型 {
    final タスクリポジトリ型 タスクリポジトリ;

    public タスク記録型 取得する(タスクID型 id) {
        return タスクリポジトリ.findById(id.value())
                .orElseThrow(IllegalArgumentException::new);
    }

    public タスク一覧型 全件取得する() {
        List<タスク記録型> 全件 = タスクリポジトリ.findAll();
        return new タスク一覧型(全件);
    }
}
