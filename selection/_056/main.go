package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e16)

var sc = bufio.NewScanner(os.Stdin)

func main() {
	sc.Split(bufio.ScanWords)

	v, e, r := scanInt(), scanInt(), scanInt()
	g := make([][]edge, v)
	for i := 0; i < v; i++ {
		g[i] = make([]edge, 0)
	}
	for i := 0; i < e; i++ {
		s, t, d := scanInt(), scanInt(), scanInt()
		g[s] = append(g[s], edge{to: t, d: d})
	}

	vs := make([]int, v)
	for i := 0; i < v; i++ {
		vs[i] = INF
	}
	vs[r] = 0

	kakutei := make([]bool, v)

	pq := NewPriorityQueue()
	pq.push(&item{v: r, w: 0})

	for pq.len() > 0 {
		element := pq.pop()

		for _, edge := range g[element.v] {
			if kakutei[edge.to] {
				continue
			}

			vs[edge.to] = min(vs[edge.to], vs[element.v]+edge.d)
			pq.push(&item{v: edge.to, w: vs[edge.to]})
		}

		kakutei[element.v] = true
	}

	for i := 0; i < v; i++ {
		if vs[i] == INF {
			fmt.Println("INF")
		} else {
			fmt.Println(vs[i])
		}
	}
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

type priorityQueue struct {
	pq pq
}

type edge struct {
	to, d int
}

type item struct {
	v, w, index int
}

type pq []*item

func (pq pq) Len() int { return len(pq) }

func (pq pq) Less(i, j int) bool {
	// We want Pop to give us the highest, not lowest, priority so we use greater than here.
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

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func scanStr() string {
	sc.Scan()

	return sc.Text()
}

// a[i] >= v を満たす最小のインデックスを取得する
func lowerBound(a []int, v int) int {
	ng, ok := -1, len(a)
	for ok-ng > 1 {
		mid := (ok + ng) / 2
		if a[mid] >= v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}

// a[i] > v を満たす最小のインデックスを取得する
func upperBound(a []int, v int) int {
	ng, ok := -1, len(a)
	for ok-ng > 1 {
		mid := (ok + ng) / 2
		if a[mid] > v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}

func min(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Min(float64(res), float64(v)))
	}

	return res
}

func max(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Max(float64(res), float64(v)))
	}

	return res
}

func abs(a int) int {
	return int(math.Abs(float64(a)))
}
