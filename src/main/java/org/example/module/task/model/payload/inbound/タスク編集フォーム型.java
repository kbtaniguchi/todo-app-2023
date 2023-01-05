package org.example.module.task.model.payload.inbound;

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
    Integer バージョン;
    @NotNull
    @Size(min = 1, max = 255)
    String 名称;

    @Size(max = 255)
    String メモ;

    public タスク編集指示型 コマンドへ変換する() {
        return new タスク編集指示型(
                new タスクID型(id),
                new バージョン型(バージョン),
                new タスク名称型(名称),
                new タスクメモ型(メモ)
        );
    }
}
