package org.example.module.task.model.command;

import org.example.framework.entity.コマンド型;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.type.タスクID型;

public record タスク削除指示型(
        タスクID型 タスクID,
        バージョン型 バージョン

) implements コマンド型<タスク記録> {
}
