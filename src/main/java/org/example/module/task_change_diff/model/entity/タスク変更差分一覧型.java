package org.example.module.task_change_diff.model.entity;

import java.io.Serializable;
import java.util.List;

public class タスク変更差分一覧型 implements Serializable {
    List<タスク変更差分記録型> list;

    public タスク変更差分一覧型(List<タスク変更差分記録型> list) {
        this.list = list;
    }

    public int size() {
        return list.size();
    }
}
