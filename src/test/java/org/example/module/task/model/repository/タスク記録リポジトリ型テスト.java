package org.example.module.task.model.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.example.module.task.model.entity.タスク記録;
import org.example.module.task.model.type.タスク進捗状態;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class タスク記録リポジトリ型テスト {
    @Autowired
    タスク記録リポジトリ型 sut;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Test
    void 登録_更新_削除() {
        タスク記録 task = new タスク記録();
        task.名称("テストタスク");
        task.進捗状態(タスク進捗状態.TODO);

        タスク記録 saved = sut.save(task);
        saved.メモ("更新");

        タスク記録 updated = sut.save(saved);
        sut.delete(updated);

        Optional<タスク記録> searched = sut.findById(updated.id());
        Assertions.assertTrue(searched.isEmpty());

        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        List resultList = auditReader.createQuery()
                .forRevisionsOfEntity(タスク記録.class, false, true)
                .add(AuditEntity.id().eq(updated.id()))
                .getResultList();
        Assertions.assertEquals(resultList.size(), 3);

        resultList.forEach(o -> {
            Object[] result = (Object[]) o;
            System.out.println(result[0]);
            System.out.printf("%s, %s%n", result[1], result[2]);
        });
    }

}