package main

import (
	"container/heap"
	"fmt"
)

type Edge struct {
	To   int
	Cost int64
}

type Vertex struct {
	Pos   int
	Cost  int64
	index int
}

type PriorityQueue []*Vertex

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
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

	g := make([][]Edge, v)
	// TODO: 標準入力の高速化対応
	for i := 0; i < e; i++ {
		var s, t int
		var d int64
		fmt.Scan(&s, &t, &d)

		g[s] = append(g[s], Edge{To: t, Cost: d})
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
		from := heap.Pop(&pq).(*Vertex)
		dist[from.Pos] = cur[from.Pos]

		for i := 0; i < len(g[from.Pos]); i++ {
			edge := g[from.Pos][i]
			if dist[edge.To] == INF && cur[edge.To] > cur[from.Pos]+edge.Cost {
				cur[edge.To] = cur[from.Pos] + edge.Cost
				heap.Push(&pq, &Vertex{Pos: edge.To, Cost: cur[edge.To]})
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
