package org.example.module.task.model.rule;

import lombok.RequiredArgsConstructor;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class タスク登録ポリシー型 {
    final タスクリポジトリ型 タスクリポジトリ;
    final static int タスク登録可能数上限 = 50;

    public boolean 違反している() {
        long 全件数 = タスクリポジトリ.count();
        return 全件数 == タスク登録可能数上限;
    }

    public String 違反メッセージ() {
        return String.format("タスクは%s個までしか登録できません", タスク登録可能数上限);
    }
}
