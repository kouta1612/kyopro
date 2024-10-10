# atcoder

## コマンドについて

abc001ディレクトリとその直下にコンテスト情報が作成される

```bash
acc new abc001
```

コンテストディレクトリ直下で新しいタスクを追加する

```bash
acc add
```

サンプルケースが正しいか確認する（AC判定の際にSオプションでスペースを無視している）

```bash
make t
```

実装したコードを提出する

```bash
make s
```

## テンプレートについて

コマンドでディレクトリを作成する際に、[atcoder-cli公式のテンプレート機能](https://github.com/Tatamo/atcoder-cli#provisioning-templates)を使用して、事前に用意した下記テンプレートコードも出力するようにしている。

```text
・各タスクで必要なMakefile（プロジェクト直下のデータをコピーしたもの）
・各タスクで実装するテンプレート
```

テンプレートコードの場所は下記コマンドで確認ができる。

```bash
acc templates
```

### 参考リンク一覧

- <https://github.com/Tatamo/atcoder-cli>
- <https://github.com/online-judge-tools/oj>

## 参考

- [テストケース](https://www.dropbox.com/sh/nx3tnilzqz7df8a/AAAYlTq2tiEHl5hsESw6-yfLa?dl=0)
