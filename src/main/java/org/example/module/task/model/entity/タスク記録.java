package org.example.module.task.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.framework.entity.記録型;
import org.example.module.task.model.type.タスク進捗状態値;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Audited
@AuditOverride(forClass = 記録型.class)
public class タスク記録 extends 記録型 {
    @Column(nullable = false)
    String 名称;
    @Column(length = 511)
    String メモ;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    タスク進捗状態値 進捗状態;
}
