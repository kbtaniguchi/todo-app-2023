package org.example.framework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class 記録型 implements Serializable {
    @Id
    @GeneratedValue
    protected Long id;
    @Version
    @Column(nullable = false)
    protected Integer バージョン;

    @CreatedBy
    @Column(nullable = false)
    protected String 作成者;
    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime 作成日時;

    @LastModifiedBy
    @Column(nullable = false)
    protected String 最終更新者;
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime 最終更新日時;

    @SuppressWarnings("unchecked")
    public <E extends 記録型> void 適用する(コマンド型<E> コマンド) {
        if (!コマンド.バージョン().equals(new バージョン型(バージョン)))
            throw new ObjectOptimisticLockingFailureException(getClass(), id);
        コマンド.編集する((E) this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        記録型 記録型 = (記録型) o;
        return id != null && Objects.equals(id, 記録型.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
