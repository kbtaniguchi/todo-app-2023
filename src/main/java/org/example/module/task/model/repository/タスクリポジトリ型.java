package org.example.module.task.model.repository;

import org.example.module.task.model.entity.タスク記録;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface タスクリポジトリ型 extends
        JpaRepository<タスク記録, Long>,
        RevisionRepository<タスク記録, Long, Integer> {
}