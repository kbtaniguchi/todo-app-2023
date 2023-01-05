package org.example.module.task.model.transfer;

import org.example.module.task.model.payload.outbound.タスク変更通知メッセージ型;

public interface タスク変更通知トランスファ型 {

    void 通知する(タスク変更通知メッセージ型 タスク変更通知メッセージ);
}
