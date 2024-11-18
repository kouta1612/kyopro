package main

import (
	"fmt"

	treemap "github.com/liyue201/gostl/ds/map"
	"github.com/liyue201/gostl/utils/comparator"
)

func main() {
	mp := treemap.New[int, int](comparator.IntComparator)

	mp.Insert(1, 50)
	n, _ := mp.Get(100)
	mp.Insert(100, n+1)

	for it := mp.Begin(); it.IsValid(); it.Next() {
		fmt.Println(it.Key(), it.Value())
	}
}
