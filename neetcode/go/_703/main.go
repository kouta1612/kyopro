package main

import (
	"container/heap"
	"fmt"
)

func main() {
	constructor := Constructor(3, []int{4, 5, 8, 2})
	fmt.Println(constructor.Add(3))
	fmt.Println(constructor.Add(5))
	fmt.Println(constructor.Add(10))
	fmt.Println(constructor.Add(9))
	fmt.Println(constructor.Add(4))
}

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
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

type KthLargest struct {
	k       int
	minheap *IntHeap
}

func Constructor(k int, nums []int) KthLargest {
	minheap := &IntHeap{}
	for _, num := range nums {
		minheap.Push(num)
	}
	fmt.Println(minheap)
	heap.Init(minheap)
	fmt.Println(minheap)
	return KthLargest{k, minheap}
}

func (m *KthLargest) Add(val int) int {
	heap.Push(m.minheap, val)
	for m.minheap.Len() > m.k {
		heap.Pop(m.minheap)
	}
	return (*m.minheap)[0]
}
