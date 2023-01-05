package org.example.framework.entity;

public interface コマンド型<E extends 記録型> {
    default void 編集する(E 記録) {
        // do nothing
    }

    default バージョン型 バージョン() {
        return new バージョン型(null);
    }
}
