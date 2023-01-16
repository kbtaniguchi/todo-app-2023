package org.example.module.task.application;

import org.example.framework.entity.バージョン型;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.entity.タスク一覧型;
import org.example.module.task.model.repository.タスクリポジトリ型;
import org.example.module.task.model.type.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class タスクシナリオテスト {
    @Autowired
    タスクを登録するUC タスクを登録する;
    @Autowired
    タスクを編集するUC タスクを編集する;
    @Autowired
    タスクの進捗状態を変更するUC タスクの進捗状態を変更する;
    @Autowired
    タスクを削除するUC タスクを削除する;
    @Autowired
    全タスクの一覧を取得するUC 全タスクの一覧を取得する;

    @Autowired
    タスクリポジトリ型 タスクリポジトリ;

    @AfterEach
    void タスクを全て消す() {
        タスクリポジトリ.deleteAll();
    }

    @Test
    void 登録_編集_状態変更_削除ができる() {
        タスク登録指示型 登録指示 = new タスク登録指示型(new タスク名称型("テスト1"), new タスクメモ型(null));
        タスク記録型 登録済み = タスクを登録する.実行する(登録指示);
        タスクID型 id = new タスクID型(登録済み.id());
        assertEquals(登録済み.バージョン(), 0);
        assertEquals(登録済み.名称(), "テスト1");
        assertNull(登録済み.メモ());
        assertEquals(登録済み.進捗状態(), タスク進捗状態区分値.TODO);

        タスク編集指示型 編集指示 = new タスク編集指示型(id, new バージョン型(0), new タスク名称型("テスト2"), new タスクメモ型("テスト2メモ"));
        タスク記録型 編集済み = タスクを編集する.実行する(編集指示);
        assertEquals(編集済み.バージョン(), 1);
        assertEquals(編集済み.名称(), "テスト2");
        assertEquals(編集済み.メモ(), "テスト2メモ");

        タスク進捗状態変更指示型 進捗状態変更指示 = new タスク進捗状態変更指示型(id, new バージョン型(1), new タスク進捗状態区分型(タスク進捗状態区分値.DONE));
        タスク記録型 状態変更済み = タスクの進捗状態を変更する.実行する(進捗状態変更指示);
        assertEquals(状態変更済み.バージョン(), 2);
        assertEquals(状態変更済み.進捗状態(), タスク進捗状態区分値.DONE);

        タスク削除指示型 削除指示 = new タスク削除指示型(id, new バージョン型(2));
        タスクを削除する.実行する(削除指示);
    }

    @Test
    void 全タスクの一覧を取得できる() {
        IntStream.range(0, 10)
                .forEach(i -> タスクを登録する.実行する(new タスク登録指示型(new タスク名称型("テスト"), new タスクメモ型(Integer.toString(i)))));
        タスク一覧型 検索結果 = 全タスクの一覧を取得する.実行する();
        assertEquals(検索結果.size(), 10);
    }

    @Test
    void 編集_状態変更_削除のユースケースに渡すコマンドのバージョンが古い場合に楽観ロックエラーになる() {
        タスク登録指示型 登録指示 = new タスク登録指示型(new タスク名称型("テスト1"), new タスクメモ型(null));
        タスク記録型 登録済み = タスクを登録する.実行する(登録指示);
        タスクID型 id = new タスクID型(登録済み.id());
        assertEquals(登録済み.バージョン(), 0);
        assertEquals(登録済み.名称(), "テスト1");
        assertNull(登録済み.メモ());

        タスク編集指示型 編集指示1 = new タスク編集指示型(id, new バージョン型(0), new タスク名称型("テスト2"), new タスクメモ型("テスト2メモ"));
        タスク記録型 編集済み = タスクを編集する.実行する(編集指示1);
        assertEquals(編集済み.バージョン(), 1);
        assertEquals(編集済み.名称(), "テスト2");
        assertEquals(編集済み.メモ(), "テスト2メモ");

        タスク編集指示型 編集指示2 = new タスク編集指示型(id, new バージョン型(0), new タスク名称型("テスト3"), new タスクメモ型("テスト3メモ"));
        assertThrows(ObjectOptimisticLockingFailureException.class, () -> タスクを編集する.実行する(編集指示2));

        タスク進捗状態変更指示型 進捗状態変更指示 = new タスク進捗状態変更指示型(id, new バージョン型(0), new タスク進捗状態区分型(タスク進捗状態区分値.DONE));
        assertThrows(ObjectOptimisticLockingFailureException.class, () -> タスクの進捗状態を変更する.実行する(進捗状態変更指示));

        タスク削除指示型 削除指示 = new タスク削除指示型(id, new バージョン型(0));
        assertThrows(ObjectOptimisticLockingFailureException.class, () -> タスクを削除する.実行する(削除指示));
    }
}