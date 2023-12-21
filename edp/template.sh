#!/bin/bash

if [ $# -ne 1 ]; then
    echo "次のような第一引数を1つ指定してください: [A-Z]" 1>&2
    exit 1
fi

# 指定したフォルダが存在しなかったら作成する
if [ ! -d $1 ]; then
    mkdir $1
fi

cp ~/Library/Preferences/atcoder-cli-nodejs/template/main.go ./$1
