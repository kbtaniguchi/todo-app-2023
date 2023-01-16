package org.example.module.task.presentation.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.framework.entity.バージョン型;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.type.タスクID型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;

import java.io.Serializable;

public class タスク編集フォーム型 implements Serializable {
    @NotNull
    Long id;

    @NotNull
    Integer version;
    @NotNull
    @Size(min = タスク名称型.最小桁数, max = タスク名称型.最大桁数)
    String name;

    @Size(max = タスクメモ型.最大桁数)
    String memo;

    public タスク編集指示型 コマンドへ変換する() {
        return new タスク編集指示型(
                new タスクID型(id),
                new バージョン型(version),
                new タスク名称型(name),
                new タスクメモ型(memo)
        );
    }
}
