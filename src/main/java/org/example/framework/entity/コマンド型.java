package org.example.framework.entity;

import org.springframework.context.ApplicationEvent;

public interface コマンド型<E extends 記録型> {
    ApplicationEvent 実行する(E 記録);

    default バージョン型 バージョン() {
        return new バージョン型(null);
    }
}
