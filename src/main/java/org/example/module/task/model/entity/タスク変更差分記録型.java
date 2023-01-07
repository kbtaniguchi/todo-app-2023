package org.example.module.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.framework.entity.不変記録型;
import org.example.module.task.model.type.タスク変更区分値;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "タスク変更差分")
public class タスク変更差分記録型 extends 不変記録型 {
    @Column(nullable = false)
    Long タスクID;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    タスク変更区分値 変更区分;
    @ElementCollection
    @CollectionTable(name = "タスク変更差分_明細", joinColumns = @JoinColumn(name = "タスク変更差分_ID"))
    List<明細型> 明細 = new ArrayList<>();

    @ToString
    @Getter
    @Setter
    @Embeddable
    public static class 明細型 {
        @Column(nullable = false)
        Integer 明細行番号;
        @Column(nullable = false)
        String 項目名;
        String 変更前の値;
        String 変更後の値;
    }
}
