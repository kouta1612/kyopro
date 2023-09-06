package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Edge struct {
	to   int
	cost int64
}

type Vertex struct {
	pos   int
	cost  int64
	index int
}

type PriorityQueue []*Vertex

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].cost < pq[j].cost
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
	reader := bufio.NewReaderSize(os.Stdin, e)
	for i := 0; i < e; i++ {
		line, _, _ := reader.ReadLine()
		datas := strings.Split(string(line), " ")
		var s, t int
		var d int64
		s, _ = strconv.Atoi(datas[0])
		t, _ = strconv.Atoi(datas[1])
		d, _ = strconv.ParseInt(datas[2], 10, 64)
		g[s] = append(g[s], Edge{to: t, cost: d})
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
	heap.Push(&pq, &Vertex{pos: r, cost: 0})

	for pq.Len() > 0 {
		from := heap.Pop(&pq).(*Vertex)
		dist[from.pos] = cur[from.pos]

		for i := 0; i < len(g[from.pos]); i++ {
			edge := g[from.pos][i]
			if dist[edge.to] == INF && cur[edge.to] > cur[from.pos]+edge.cost {
				cur[edge.to] = cur[from.pos] + edge.cost
				heap.Push(&pq, &Vertex{pos: edge.to, cost: cur[edge.to]})
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
