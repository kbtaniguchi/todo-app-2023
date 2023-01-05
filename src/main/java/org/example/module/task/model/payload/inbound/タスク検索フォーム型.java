package org.example.module.task.model.payload.inbound;

import jakarta.validation.constraints.Size;
import org.example.module.task.model.query.タスク検索条件型;
import org.example.module.task.model.type.タスク検索文字列型;

import java.io.Serializable;

public class タスク検索フォーム型 implements Serializable {

    @Size(max = 255)
    String 検索文字列;

    public タスク検索条件型 クエリへ変換する() {
        return new タスク検索条件型(
                new タスク検索文字列型(検索文字列)
        );
    }
}
