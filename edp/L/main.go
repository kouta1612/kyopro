package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const (
	INF = int(1e16)
	MOD = int(1e9) + 7
)

var sc = bufio.NewScanner(os.Stdin)

func main() {
	sc.Split(bufio.ScanWords)

	n := ni()
	a := ni1d(n)

	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, n+1)
	}

	for l := 1; l <= n; l++ {
		for i := 0; i+l <= n; i++ {
			j := i + l

			if (n-l)%2 == 0 {
				dp[i][j] = max(dp[i+1][j]+a[i], dp[i][j-1]+a[j-1])
			} else {
				dp[i][j] = min(dp[i+1][j]-a[i], dp[i][j-1]-a[j-1])
			}
		}
	}

	fmt.Println(dp[0][n])
}

func ni() int {
	sc.Scan()
	return atoi(sc.Text())
}

func ni2() (int, int) {
	return ni(), ni()
}

func ni3() (int, int, int) {
	return ni(), ni(), ni()
}

func ni1d(n int) []int {
	res := make([]int, n)
	for i := 0; i < n; i++ {
		res[i] = ni()
	}
	return res
}

func ni2d(n, m int) [][]int {
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, m)
		for j := 0; j < m; j++ {
			res[i][j] = ni()
		}
	}
	return res
}

func nf() float64 {
	sc.Scan()
	return atof(sc.Text())
}

func ns() string {
	sc.Scan()
	return sc.Text()
}

func atoi(s string) int {
	res, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}
	return res
}

func atof(s string) float64 {
	res, err := strconv.ParseFloat(sc.Text(), 64)
	if err != nil {
		panic(err)
	}
	return res
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

func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}

func lcm(a, b int) int {
	return a * b / gcd(a, b)
}

func ceil(a, b int) int {
	return (a + b - 1) / b
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

func chmax(x *int, y int) {
	*x = max(*x, y)
}

func chmin(x *int, y int) {
	*x = min(*x, y)
}

func abs(a int) int {
	return int(math.Abs(float64(a)))
}

func sqrt(x int) int {
	return int(math.Sqrt(float64(x)))
}

// nCr mod pを求める
func nCr(n, r, p int) int {
	fact := factorization(2e6, p)
	return (fact[n] * inv((fact[n-r]*fact[r])%p, p)) % p
}

// n! mod p
func factorization(n, p int) []int {
	result := make([]int, n+1)

	result[0] = 1
	for i := 1; i <= n; i++ {
		result[i] = result[i-1] * i
		result[i] %= p
	}

	return result
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

type modint struct {
	v, p int
}

func newModint(n, p int) modint {
	return modint{n % p, p}
}

func (m modint) pow(n int) modint {
	return newModint(modpow(m.v, n, m.p), m.p)
}

func (m modint) add(n int) modint {
	return newModint((m.v+n)%m.p, m.p)
}

func (m modint) sub(n int) modint {
	return newModint((m.v-n+m.p)%m.p, m.p)
}

func (m modint) mul(n int) modint {
	return newModint((m.v*n)%m.p, m.p)
}

func (m modint) div(n int) modint {
	return newModint((m.v*inv(n, m.p))%m.p, m.p)
}

func (m modint) toint() int {
	return m.v % m.p
}

// nのmod p上でのn^(-1)を求める
func inv(n, p int) int {
	return modpow(n, p-2, p)
}

// a^b mod pを求める
func modpow(a, b, p int) int {
	if b == 0 {
		return 1
	}
	if b == 1 {
		return a % p
	}

	t := modpow(a, b/2, p)
	if b%2 == 0 {
		return (t * t) % p
	} else {
		return (((t * t) % p) * a) % p
	}
}
