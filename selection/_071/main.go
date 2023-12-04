package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e16)
const MOD = 1000000007

var sc = bufio.NewScanner(os.Stdin)

func main() {
	sc.Split(bufio.ScanWords)

	n, q := scanInt(), scanInt()

	a, c := make([]int, n), make([]int, q)
	for i := 0; i < n; i++ {
		a[i] = scanInt()
	}
	for i := 0; i < q; i++ {
		c[i] = scanInt() - 1
	}

	p := make([]int, n)
	for i := 0; i < n-1; i++ {
		p[i+1] = modpow(a[i], a[i+1], MOD)
	}

	sum := make([]int, n)
	for i := 1; i < n; i++ {
		sum[i] = (sum[i-1] + p[i]) % MOD
	}

	ans := (sum[c[0]] + sum[c[q-1]]) % MOD
	for i := 0; i < q-1; i++ {
		u, v := c[i], c[i+1]
		if u > v {
			u, v = v, u
		}

		ans = (ans + sum[v] - sum[u] + MOD) % MOD
	}

	fmt.Println(ans)
}

func modpow(m, n, p int) int {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return m % p
	}

	t := modpow(m, n/2, p)
	if n%2 == 0 {
		return (t * t) % p
	} else {
		return ((t * t) % p * m) % p
	}
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
