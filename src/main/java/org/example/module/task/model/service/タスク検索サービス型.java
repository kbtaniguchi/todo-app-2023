package org.example.module.task.model.service;

import org.example.module.task.model.payload.outbound.タスク検索結果型;
import org.example.module.task.model.query.タスク検索条件型;

import java.util.List;

public interface タスク検索サービス型 {

    List<タスク検索結果型> 検索する(タスク検索条件型 タスク検索条件);
}
