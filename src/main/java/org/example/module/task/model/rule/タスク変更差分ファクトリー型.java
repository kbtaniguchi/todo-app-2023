package org.example.module.task.model.rule;

import org.example.framework.entity.イベント型;
import org.example.framework.entity.コマンド型;
import org.example.module.task.model.command.タスク削除指示型;
import org.example.module.task.model.command.タスク登録指示型;
import org.example.module.task.model.command.タスク編集指示型;
import org.example.module.task.model.command.タスク進捗状態変更指示型;
import org.example.module.task.model.entity.タスク変更差分記録型;
import org.example.module.task.model.entity.タスク記録型;
import org.example.module.task.model.type.タスク変更区分値;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class タスク変更差分ファクトリー型 {
    public タスク変更差分記録型 作成する(イベント型<タスク記録型> イベント) {
        コマンド型<タスク記録型> 適用コマンド = イベント.適用コマンド();
        タスク変更差分記録型 記録 = new タスク変更差分記録型()
                .タスクID(イベント.エンティティ().id())
                .バージョン(イベント.エンティティ().バージョン());

        if (適用コマンド instanceof タスク登録指示型) {
            記録.変更区分(タスク変更区分値.登録);
            return 記録;
        }
        if (適用コマンド instanceof タスク編集指示型) {
            記録.変更区分(タスク変更区分値.編集);
            List<タスク変更差分記録型.明細型> 明細 = new ArrayList<>();
            if (!Objects.equals(イベント.コマンド適用前().名称(), イベント.エンティティ().名称()))
                明細.add(new タスク変更差分記録型.明細型()
                        .明細行番号(1)
                        .項目名("名称")
                        .変更前の値(イベント.コマンド適用前().名称())
                        .変更後の値(イベント.エンティティ().名称()));
            if (!Objects.equals(イベント.コマンド適用前().メモ(), イベント.エンティティ().メモ()))
                明細.add(new タスク変更差分記録型.明細型()
                        .明細行番号(明細.size() + 1)
                        .項目名("メモ")
                        .変更前の値(イベント.コマンド適用前().メモ())
                        .変更後の値(イベント.エンティティ().メモ()));
            if (!明細.isEmpty()) 記録.明細(明細);
            return 記録;
        }
        if (適用コマンド instanceof タスク削除指示型) {
            記録.変更区分(タスク変更区分値.削除);
            return 記録;
        }
        if (適用コマンド instanceof タスク進捗状態変更指示型) {
            記録.変更区分(タスク変更区分値.進捗状態変更);
            タスク変更差分記録型.明細型 明細 = new タスク変更差分記録型.明細型()
                    .明細行番号(1)
                    .項目名("進捗状態")
                    .変更前の値(イベント.コマンド適用前().進捗状態().toString())
                    .変更後の値(イベント.エンティティ().進捗状態().toString());
            記録.明細(Collections.singletonList(明細));
            return 記録;
        }

        throw new IllegalArgumentException();
    }
}
