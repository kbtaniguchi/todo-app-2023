package org.example.module.task.model.rule;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class タスクポリシー型 {
    final タスクリポジトリ型 タスクリポジトリ;

    public boolean 違反している() {
        long 全件数 = タスクリポジトリ.count();
        return 全件数 > 50;
    }
}
