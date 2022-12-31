package org.example.module.task.model.repository;

import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.type.タスク進捗状態値;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.history.Revisions;

import java.util.Optional;

@SpringBootTest
class タスク記録リポジトリ型テスト {
    @Autowired
    タスク記録リポジトリ型 sut;

    @Test
    void 登録_更新_削除() {
        タスク記録 task = new タスク記録();
        task.名称("テストタスク");
        task.進捗状態(タスク進捗状態値.TODO);

        タスク記録 saved = sut.save(task);
        saved.メモ("更新");

        タスク記録 updated = sut.save(saved);
        sut.delete(updated);

        Optional<タスク記録> searched = sut.findById(updated.id());
        Assertions.assertTrue(searched.isEmpty());

        Revisions<Integer, タスク記録> revisions = sut.findRevisions(updated.id());
        Assertions.assertEquals(revisions.stream().count(), 3);
        revisions.forEach(System.out::println);
    }

}