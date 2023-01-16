package org.example.module.task_change_diff.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.framework.entity.導出記録型;
import org.example.module.task_change_diff.model.type.タスク変更区分値;
import org.example.module.task_change_diff.model.type.タスク変更区分型;
import org.example.module.task_change_diff.model.type.タスク項目値型;
import org.example.module.task_change_diff.model.type.タスク項目名称型;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "タスク変更差分")
public class タスク変更差分記録型 extends 導出記録型 {
    @Column(name = "タスクID", nullable = false)
    Long taskId;
    @Column(name = "変更区分", length = タスク変更区分型.最大桁数, nullable = false)
    @Enumerated(EnumType.STRING)
    タスク変更区分値 changeType;
    @ElementCollection
    @CollectionTable(name = "タスク変更差分_明細", joinColumns = @JoinColumn(name = "タスク変更差分_ID"))
    List<明細> details = new ArrayList<>();

    @ToString
    @Getter
    @Setter
    @Embeddable
    public static class 明細 {
        @Column(name = "明細行番号", nullable = false)
        Integer lineNumber;
        @Column(name = "項目名", length = タスク項目名称型.最大桁数, nullable = false)
        String fieldName;
        @Column(name = "変更前の値", length = タスク項目値型.最大桁数)
        String beforeValue;
        @Column(name = "変更後の値", length = タスク項目値型.最大桁数)
        String afterValue;
    }
}
