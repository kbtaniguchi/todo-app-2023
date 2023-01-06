package org.example.module.task.model.payload.outbound;

import org.example.module.task.model.entity.タスク記録;

import java.io.Serializable;
import java.util.List;

public class タスク検索結果型 implements Serializable {
    List<タスク記録> list;

    public タスク検索結果型(List<タスク記録> list) {
        this.list = list;
    }

    public int 件数() {
        return list.size();
    }
}
