package org.example.module.task.model.payload.inbound;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;

import java.io.Serializable;

public class タスク登録フォーム型 implements Serializable {
    @NotNull
    @Size(min = 1, max = 255)
    String 名称;

    @Size(max = 255)
    String メモ;

    public タスク登録指示型 コマンドへ変換する() {
        return new タスク登録指示型(
                new タスク名称型(名称),
                new タスクメモ型(メモ)
        );
    }
}
