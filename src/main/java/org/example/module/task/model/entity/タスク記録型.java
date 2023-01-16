package org.example.module.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.framework.entity.実体記録型;
import org.example.module.task.model.type.タスクメモ型;
import org.example.module.task.model.type.タスク名称型;
import org.example.module.task.model.type.タスク進捗状態区分値;
import org.example.module.task.model.type.タスク進捗状態区分型;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.util.SerializationUtils;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "タスク")
@Audited
@AuditOverride(forClass = 実体記録型.class)
public class タスク記録型 extends 実体記録型 {
    @Column(length = タスク名称型.最大桁数, nullable = false)
    String 名称;
    @Column(length = タスクメモ型.最大桁数)
    String メモ;
    @Column(length = タスク進捗状態区分型.最大桁数, nullable = false)
    @Enumerated(EnumType.STRING)
    タスク進捗状態区分値 進捗状態;

    public タスク記録型 ディープコピーする() {
        return SerializationUtils.clone(this);
    }
}
