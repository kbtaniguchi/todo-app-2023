package org.example.framework;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EventEntity {
    @Id
    @GeneratedValue
    protected Long id;
    @Version
    @Column(nullable = false)
    protected Integer version;

    @CreatedBy
    protected String createdBy;
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedBy
    protected String revisedBy;
    @LastModifiedDate
    protected LocalDateTime revisedAt;
}
