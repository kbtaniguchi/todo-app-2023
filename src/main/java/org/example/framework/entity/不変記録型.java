package org.example.framework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class 不変記録型 implements Serializable, 記録型 {
    @Id
    @GeneratedValue
    protected Long id;
    @CreatedBy
    @Column(nullable = false)
    protected String 作成者;
    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime 作成日時;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        不変記録型 記録 = (不変記録型) o;
        return id != null && Objects.equals(id, 記録.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
