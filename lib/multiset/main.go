package main

import (
	"fmt"

	"github.com/liyue201/gostl/ds/set"
	"github.com/liyue201/gostl/utils/comparator"
)

func main() {
	// 重複した値を残したいときに利用する
	// Erase関数は重複した値を全削除するので注意
	// 単一ノードだけ削除したい場合はrbtreeを利用すること
	ms := set.NewMultiSet[int](comparator.IntComparator)

	ms.Insert(1)
	ms.Insert(2)
	ms.Insert(2)
	ms.Insert(4)

	for it := ms.Begin(); it.IsValid(); it.Next() {
		fmt.Println(it.Value())
	}
}
