package main

import (
	"container/heap"
	"fmt"
)

func main() {
	fmt.Println(lastStoneWeight([]int{2, 7, 4, 1, 8, 1}))
}

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func lastStoneWeight(stones []int) int {
	vs := &IntHeap{}
	for _, v := range stones {
		vs.Push(v)
	}
	heap.Init(vs)

	for vs.Len() > 1 {
		x, y := heap.Pop(vs).(int), heap.Pop(vs).(int)
		if x != y {
			heap.Push(vs, abs(x-y))
		}
	}

	if vs.Len() == 1 {
		return (*vs)[0]
	}
	return 0
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
