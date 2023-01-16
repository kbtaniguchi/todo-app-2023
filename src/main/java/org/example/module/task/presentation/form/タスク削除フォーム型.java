package org.example.module.task.presentation.form;

import jakarta.validation.constraints.NotNull;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.type.タスクID型;

import java.io.Serializable;

public class タスク削除フォーム型 implements Serializable {
    @NotNull
    Long id;

    @NotNull
    Integer version;

    public タスク削除指示型 コマンドへ変換する() {
        return new タスク削除指示型(
                new タスクID型(id),
                new バージョン型(version)
        );
    }
}
