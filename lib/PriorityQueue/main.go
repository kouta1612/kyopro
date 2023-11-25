package main

import (
	"container/heap"
	"fmt"
)

func main() {
	pq := NewPriorityQueue()
	pq.push(&item{v: 0, w: 10})
	pq.push(&item{v: 1, w: 1})
	fmt.Println(pq.pop(), pq.len())
	fmt.Println(pq.pop(), pq.len())
}

// 以降はプライオリティーキュー自前ライブラリ
type priorityQueue struct {
	pq pq
}

func NewPriorityQueue() *priorityQueue {
	pq := make(pq, 0)
	heap.Init(&pq)

	return &priorityQueue{pq: pq}
}

func (p *priorityQueue) len() int {
	return p.pq.Len()
}

func (p *priorityQueue) push(item *item) {
	heap.Push(&p.pq, item)
}

func (p *priorityQueue) pop() *item {
	return heap.Pop(&p.pq).(*item)
}

// プライオリティーキューに突っ込むオブジェクト
type item struct {
	v, w, index int
}

// 以降はcontainer/heapの実装クラス
type pq []*item

func (pq pq) Len() int { return len(pq) }

// デフォルトでは優先度の低い順
// 高い順にしたい場合: return pq[i].w > pq[j].w に修正する
func (pq pq) Less(i, j int) bool {
	return pq[i].w < pq[j].w
}

func (pq pq) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *pq) Push(x interface{}) {
	n := len(*pq)
	item := x.(*item)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *pq) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil  // avoid memory leak
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}
