package main

import (
	"container/heap"
	"fmt"
)

type IntHeap []int

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h IntHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func main() {
	h := &IntHeap{}
	heap.Init(h)
	var q int
	fmt.Scan(&q)
	for i := 0; i < q; i++ {
		var query int
		fmt.Scan(&query)
		if query == 1 {
			var name int
			fmt.Scan(&name)

			heap.Push(h, name)
		}
		if query == 2 {
			out := heap.Pop(h)
			heap.Push(h, out.(int))
			fmt.Println(out)
		}
		if query == 3 {
			heap.Pop(h)
		}
	}
}
