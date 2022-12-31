package org.example.framework.entity;

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
public abstract class エンティティ型 {
    @Id
    @GeneratedValue
    protected Long id;
    @Version
    @Column(nullable = false)
    protected Integer バージョン;

    @CreatedBy
    protected String 作成者;
    @CreatedDate
    protected LocalDateTime 作成日時;

    @LastModifiedBy
    protected String 最終更新者;
    @LastModifiedDate
    protected LocalDateTime 最終更新日時;
}
