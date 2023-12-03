package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
)

const INF = int(1e16)

var sc = bufio.NewScanner(os.Stdin)

type point struct {
	i, v int
}

type edge struct {
	u, v, cost int
}

func main() {
	sc.Split(bufio.ScanWords)

	n := scanInt()

	xs, ys := make([]point, n), make([]point, n)
	for i := 0; i < n; i++ {
		xs[i], ys[i] = point{i, scanInt()}, point{i, scanInt()}
	}
	sort.Slice(xs, func(i, j int) bool { return xs[i].v < xs[j].v })
	sort.Slice(ys, func(i, j int) bool { return ys[i].v < ys[j].v })

	es := make([]edge, 0)
	for i := 0; i < n-1; i++ {
		es = append(es, edge{xs[i].i, xs[i+1].i, abs(xs[i].v - xs[i+1].v)})
		es = append(es, edge{ys[i].i, ys[i+1].i, abs(ys[i].v - ys[i+1].v)})
	}
	sort.Slice(es, func(i, j int) bool { return es[i].cost < es[j].cost })

	uf := newUnionFind(2 * (n - 1))
	ans := 0
	for i := 0; i < 2*(n-1); i++ {
		if uf.unite(es[i].u, es[i].v) {
			ans += es[i].cost
		}
	}

	fmt.Println(ans)
}

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func scanFloat() float64 {
	sc.Scan()

	res, err := strconv.ParseFloat(sc.Text(), 64)
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

type unionfind struct {
	// par[x]: 要素 x の親頂点の番号 (自身が根の場合は −1)
	// rank[x]: 要素 x の属する根付き木の高さ
	// siz[x]: 要素 x の属する根付き木に含まれる頂点数
	par, rank, siz []int
}

func newUnionFind(n int) *unionfind {
	result := new(unionfind)
	result.par, result.rank, result.siz = make([]int, n), make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		result.par[i] = -1
		result.rank[i] = 0
		result.siz[i] = 1
	}
	return result
}

func (u *unionfind) root(x int) int {
	if u.par[x] == -1 {
		return x
	}
	// 経路圧縮
	u.par[x] = u.root(u.par[x])
	return u.par[x]
}

func (u *unionfind) same(x, y int) bool {
	return u.root(x) == u.root(y)
}

func (u *unionfind) unite(x, y int) bool {
	rx, ry := u.root(x), u.root(y)
	if rx == ry {
		return false
	}

	// union by rank
	if u.rank[x] < u.rank[y] {
		rx, ry = ry, rx
	}
	u.par[ry] = rx
	if u.rank[rx] == u.rank[ry] {
		u.rank[rx]++
	}
	u.siz[rx] += u.siz[ry]

	return true
}

func (u *unionfind) size(x int) int {
	return u.siz[u.root(x)]
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

func sqrt(x int) int {
	return int(math.Sqrt(float64(x)))
}
