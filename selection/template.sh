#!/bin/bash

if [ $# -ne 1 ]; then
    echo "次のような第一引数を1つ指定してください: _xxx" 1>&2
    exit 1
fi

cp ~/Library/Preferences/atcoder-cli-nodejs/template/main.go ./$1
