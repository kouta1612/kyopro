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

	n, k := scanInt(), scanInt()
	c, r := make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		c[i], r[i] = scanInt(), scanInt()
	}
	a, b := make([]int, k), make([]int, k)
	for i := 0; i < k; i++ {
		a[i], b[i] = scanInt()-1, scanInt()-1
	}

	g := make([][]int, n)
	for i := 0; i < n; i++ {
		g[i] = make([]int, 0)
	}
	for i := 0; i < k; i++ {
		g[a[i]] = append(g[a[i]], b[i])
		g[b[i]] = append(g[b[i]], a[i])
	}

	graph := make([][]int, n)
	for i := 0; i < n; i++ {
		graph[i] = make([]int, 0)
	}

	for i := 0; i < n; i++ {
		dist := bfs(g, i)
		for j, v := range dist {
			if v == 0 || v == INF {
				continue
			}
			if r[i] < v {
				continue
			}

			graph[i] = append(graph[i], j)
		}
	}

	ans := dijkstra(graph, c, 0)
	fmt.Println(ans[n-1])
}

func bfs(g [][]int, s int) []int {
	n := len(g)

	dist := make([]int, n)
	for i := 0; i < n; i++ {
		dist[i] = INF
	}
	dist[s] = 0

	q := make([]int, 0)
	q = append(q, s)
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		for _, v := range g[now] {
			if dist[v] != INF {
				continue
			}

			dist[v] = dist[now] + 1
			q = append(q, v)
		}
	}

	return dist
}

func dijkstra(g [][]int, costs []int, s int) []int {
	n := len(g)
	kakutei := make([]bool, n)
	result := make([]int, n)
	for i := 0; i < n; i++ {
		result[i] = INF
	}
	result[s] = 0

	pq := NewPriorityQueue()
	pq.push(&item{v: s, w: 0})
	for pq.len() > 0 {
		now := pq.pop()
		for _, edge := range g[now.v] {
			if kakutei[edge] {
				continue
			}
			if result[edge] <= result[now.v]+costs[now.v] {
				continue
			}

			result[edge] = result[now.v] + costs[now.v]
			pq.push(&item{v: edge, w: result[edge]})
		}
		kakutei[now.v] = true
	}

	return result
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
