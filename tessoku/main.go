package main

import (
	"container/heap"
	"fmt"
)

type To struct {
	Pos  int
	Cost int64
}

type Vertex struct {
	Pos   int
	Cost  int64
	index int
}

// A PriorityQueue implements heap.Interface and holds Items.
type PriorityQueue []*Vertex

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	// We want Pop to give us the highest, not lowest, priority so we use greater than here.
	return pq[i].Cost < pq[j].Cost
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*Vertex)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil  // avoid memory leak
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}

const INF = 1 << 40

func main() {
	var v, e, r int
	fmt.Scan(&v, &e, &r)

	g := make([][]To, v)
	// TODO: 標準入力の高速化対応
	for i := 0; i < e; i++ {
		var s, t int
		var d int64
		fmt.Scan(&s, &t, &d)

		g[s] = append(g[s], To{Pos: t, Cost: d})
	}

	pq := make(PriorityQueue, 0)
	heap.Init(&pq)

	cur := make([]int64, v)
	dist := make([]int64, v)
	for i := 0; i < v; i++ {
		cur[i] = INF
		dist[i] = INF
	}
	cur[r] = 0
	heap.Push(&pq, &Vertex{Pos: r, Cost: 0})

	for pq.Len() > 0 {
		now := heap.Pop(&pq).(*Vertex)

		if dist[now.Pos] != INF {
			continue
		}

		dist[now.Pos] = cur[now.Pos]

		for i := 0; i < len(g[now.Pos]); i++ {
			next := g[now.Pos][i]
			if dist[next.Pos] == INF && cur[next.Pos] > cur[now.Pos]+next.Cost {
				cur[next.Pos] = cur[now.Pos] + next.Cost
				heap.Push(&pq, &Vertex{Pos: next.Pos, Cost: cur[next.Pos]})
			}
		}
	}

	for i := 0; i < v; i++ {
		if dist[i] == INF {
			fmt.Println("INF")
		} else {
			fmt.Println(dist[i])
		}
	}
}
