package main

import (
	"fmt"

	"github.com/liyue201/gostl/ds/set"
	"github.com/liyue201/gostl/utils/comparator"
)

func main() {
	// 重複した値を残したいときに利用する
	ms := set.NewMultiSet[int](comparator.IntComparator)

	ms.Insert(1)
	ms.Insert(2)
	ms.Insert(2)
	ms.Insert(4)

	for it := ms.Begin(); it.IsValid(); it.Next() {
		fmt.Println(it.Value())
	}
}
