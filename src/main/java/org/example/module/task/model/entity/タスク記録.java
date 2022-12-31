package org.example.module.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.framework.entity.エンティティ型;
import org.example.module.task.model.type.タスク進捗状態値;
import org.hibernate.Hibernate;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Audited
@AuditOverride(forClass = エンティティ型.class)
public class タスク記録 extends エンティティ型 {
    @Column(nullable = false)
    String 名称;
    String メモ;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    タスク進捗状態値 進捗状態;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        タスク記録 task = (タスク記録) o;
        return this.id != null && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
