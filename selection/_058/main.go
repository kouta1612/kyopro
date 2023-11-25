package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = 1 << 60

var sc = bufio.NewScanner(os.Stdin)

type edge struct {
	to, cost int
}

func main() {
	sc.Split(bufio.ScanWords)

	n, m, k, s, p, q := scanInt(), scanInt(), scanInt(), scanInt(), scanInt(), scanInt()

	// 移動できない地域
	ngs := make(map[int]bool)
	for i := 0; i < n+1; i++ {
		ngs[i] = false
	}

	c := make([]int, k)
	for i := 0; i < k; i++ {
		c[i] = scanInt()
		ngs[c[i]] = true
	}

	// mp[i]: iから移動できる地域のリスト
	mp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		mp[i] = make([]int, 0)
	}
	for i := 0; i < m; i++ {
		from, to := scanInt(), scanInt()
		mp[from] = append(mp[from], to)
		mp[to] = append(mp[to], from)
	}
	for i := 0; i < k; i++ {
		mp[0] = append(mp[0], c[i])
		mp[c[i]] = append(mp[c[i]], 0)
	}

	// 危険な街かどうかを判定
	dvs := make([]bool, n+1)
	// dist[i]: 仮想的な地域（町0）から町iへの距離
	dist := make([]int, n+1)
	for i := 0; i < n+1; i++ {
		dist[i] = INF
	}
	dist[0] = 0

	queue := make([]int, 0)
	queue = append(queue, 0)
	for len(queue) > 0 {
		now := queue[0]
		queue = queue[1:]

		for _, v := range mp[now] {
			if dist[v] != INF {
				continue
			}
			dist[v] = dist[now] + 1
			queue = append(queue, v)
		}
	}

	for i := 1; i <= n; i++ {
		if dist[i] <= s+1 {
			dvs[i] = true
		}
	}

	g := make([][]edge, n+1)
	for i := 1; i < n+1; i++ {
		g[i] = make([]edge, 0)
		for _, v := range mp[i] {
			if ngs[v] || ngs[i] {
				continue
			}

			if v == n {
				g[i] = append(g[i], edge{to: v, cost: 0})
			} else if dvs[v] {
				g[i] = append(g[i], edge{to: v, cost: q})
			} else {
				g[i] = append(g[i], edge{to: v, cost: p})
			}
		}
	}

	ans := dijkstra(g, 1)

	fmt.Println(ans[n])
}

func dijkstra(g [][]edge, s int) []int {
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
			if kakutei[edge.to] {
				continue
			}
			if result[edge.to] <= result[now.v]+edge.cost {
				continue
			}

			result[edge.to] = result[now.v] + edge.cost
			pq.push(&item{v: edge.to, w: result[edge.to]})
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
