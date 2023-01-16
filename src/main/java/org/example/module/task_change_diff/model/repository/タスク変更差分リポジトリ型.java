package org.example.module.task_change_diff.model.repository;

import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface タスク変更差分リポジトリ型 extends
        JpaRepository<タスク変更差分記録型, Long> {

    List<タスク変更差分記録型> findByTaskId(Long taskId);
}