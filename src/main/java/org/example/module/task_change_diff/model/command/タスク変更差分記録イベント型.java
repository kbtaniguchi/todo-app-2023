package org.example.module.task_change_diff.model.command;

import lombok.Getter;
import org.example.module.task_change_diff.model.entity.タスク変更差分記録型;
import org.springframework.context.ApplicationEvent;

@Getter
public class タスク変更差分記録イベント型 extends ApplicationEvent {
    タスク変更差分記録型 記録;

    public タスク変更差分記録イベント型(タスク変更差分記録型 記録) {
        super(記録);
        this.記録 = 記録;
    }
}
