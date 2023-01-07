package org.example.framework.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
@Getter
public class イベント型<E extends 記録型> extends ApplicationEvent {

    E エンティティ;
    コマンド型<E> 適用コマンド;
    E コマンド適用前;

    public イベント型(E エンティティ, コマンド型<E> 適用コマンド, E コマンド適用前) {
        super(エンティティ);
        this.エンティティ = エンティティ;
        this.適用コマンド = 適用コマンド;
        this.コマンド適用前 = コマンド適用前;
    }
}
