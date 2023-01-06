package org.example.framework.entity;

public interface コマンド型<E extends 記録型> {
    void 編集する(E 記録);

    default バージョン型 バージョン() {
        return new バージョン型(null);
    }
}
