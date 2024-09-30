package main

import (
	"fmt"

	"github.com/liyue201/gostl/ds/priorityqueue"
	"github.com/liyue201/gostl/utils/comparator"
)

func main() {
	// 要素の大きい順に取り出せる
	q := priorityqueue.New[int](comparator.Reverse(comparator.IntComparator))

	// 要素の小さい順に取り出せる
	// q := priorityqueue.New[int](comparator.IntComparator)

	// 要素がオブジェクトの場合もcomparatorを実装してソートできる
	// q := priorityqueue.New[task](func(a, b int) int {
	// 	return task[a].time < task[b].time
	// })

	q.Push(4)
	q.Push(13)
	q.Push(7)
	q.Push(9)
	q.Push(0)
	q.Push(88)

	for !q.Empty() {
		fmt.Printf("%v\n", q.Pop())
	}
}
