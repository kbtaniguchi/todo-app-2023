package org.example.module.task.model.entity;

import java.io.Serializable;
import java.util.List;

public class タスク一覧型 implements Serializable {
    List<タスク記録型> list;

    public タスク一覧型(List<タスク記録型> list) {
        this.list = list;
    }

    public int size() {
        return list.size();
    }
}
