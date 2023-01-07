package org.example.module.task.model.repository;

import org.example.module.task.model.entity.タスク変更差分記録型;
import org.springframework.data.jpa.repository.JpaRepository;

public interface タスク変更差分リポジトリ型 extends
        JpaRepository<タスク変更差分記録型, Long> {
}