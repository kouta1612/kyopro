package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"

	"github.com/liyue201/gostl/ds/priorityqueue"
	"golang.org/x/exp/constraints"
)

const (
	INF = 1 << 60
	MOD = int(1e9) + 7
)

var sc = bufio.NewScanner(os.Stdin)
var out = bufio.NewWriter(os.Stdout)

func main() {
	defer out.Flush()

	h, w := ni2()
	n, m := ni2()

	// light: 0: 光届いてない, 1: 光源位置, 2: 光っている
	light, block := make([][]int, h), make([][]bool, h)
	for i := 0; i < h; i++ {
		light[i], block[i] = make([]int, w), make([]bool, w)
	}

	for i := 0; i < n; i++ {
		a, b := ni()-1, ni()-1
		light[a][b] = 1
	}
	for i := 0; i < m; i++ {
		c, d := ni()-1, ni()-1
		block[c][d] = true
	}

	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if light[i][j] != 1 {
				continue
			}
			for d := -w; d <= 0; d++ {
				nj := j + d
				if nj < 0 || nj >= w {
					continue
				}
				if block[i][nj] {
					break
				}
				light[i][nj] = 2
			}
			for d := 0; d <= w; d++ {
				nj := j + d
				if nj < 0 || nj >= w {
					continue
				}
				if block[i][nj] {
					break
				}
				light[i][nj] = 2
			}
			for d := -h; d <= 0; d++ {
				ni := i + d
				if i < 0 || i >= w {
					continue
				}
				if block[ni][j] {
					break
				}
				light[ni][j] = 2
			}
			for d := 0; d <= h; d++ {
				ni := i + d
				if i < 0 || i >= w {
					continue
				}
				if block[ni][j] {
					break
				}
				light[ni][j] = 2
			}
		}
	}

	ans := 0
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if light[i][j] == 2 {
				ans++
			}
		}
	}

	fmt.Println(ans)
}

func init() {
	sc.Buffer([]byte{}, math.MaxInt64)
	sc.Split(bufio.ScanWords)
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

func ni1d2(n int) ([]int, []int) {
	res1, res2 := make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		res1[i], res2[i] = ni2()
	}
	return res1, res2
}

func ni1d3(n int) ([]int, []int, []int) {
	res1, res2, res3 := make([]int, n), make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		res1[i], res2[i], res3[i] = ni3()
	}
	return res1, res2, res3
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

func nb() byte {
	sc.Scan()
	return sc.Bytes()[0]
}

func print(v ...interface{}) {
	_, e := fmt.Fprint(out, v...)
	if e != nil {
		panic(e)
	}
}

func println(v ...interface{}) {
	_, e := fmt.Fprintln(out, v...)
	if e != nil {
		panic(e)
	}
}

func printf(format string, v ...interface{}) {
	fmt.Fprintf(out, format, v...)
}

func printIntLn(ns []int) {
	res := make([]interface{}, 0, len(ns))
	for _, v := range ns {
		res = append(res, v)
	}
	println(res...)
}

func printStringLn(ns []string) {
	res := make([]interface{}, 0, len(ns))
	for _, v := range ns {
		res = append(res, v)
	}
	println(res...)
}

// 方向ベクトル
func dij() ([]int, []int) {
	// → ↓ ← ↑ ↘ ↙ ↗ ↖
	var di []int = []int{0, 1, 0, -1, 1, 1, -1, -1}
	var dj []int = []int{1, 0, -1, 0, 1, -1, 1, -1}
	return di, dj
}

func itoa(n int) string {
	return strconv.Itoa(n)
}

func atoi(s string) int {
	res, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}
	return res
}

func atof(s string) float64 {
	res, err := strconv.ParseFloat(s, 64)
	if err != nil {
		panic(err)
	}
	return res
}

// sがtの部分文字列であるかどうか
func isSubString(s, t string) bool {
	if len(s) > len(t) {
		panic("s'size must be smaller than t")
	}

	si := 0

	for i := 0; i < len(t); i++ {
		if s[si] == t[i] {
			si++
		}
		if si == len(s) {
			return true
		}
	}

	return false
}

/*
指定したスライスの順列を生成する。（要素が重複していてもOK）
全候補を試したい場合は、事前にスライスをソートしておく。
ex:

	for {
		// aの処理

		if !next_permutation(a) {
			break
		}
	}
*/
func next_permutation(a []int) bool {
	// a[l] < a[l+1]を満たす最大のlを求める
	l := -1
	for i := 0; i < len(a)-1; i++ {
		if a[i] < a[i+1] {
			l = i
		}
	}

	if l == -1 {
		sort.Ints(a)
		return false
	}

	// a[l] < a[r]を満たす最大のrを求める
	r := len(a) - 1
	for i := r; i > l; i-- {
		if a[l] < a[i] {
			r = i
			break
		}
	}

	a[l], a[r] = a[r], a[l]
	// [l+1,n-1]が降順なので逆順にする
	for i := l + 1; i <= (l+len(a))/2; i++ {
		a[i], a[len(a)-(i-l)] = a[len(a)-(i-l)], a[i]
	}

	return true
}

/*
指定したスライスの順列を逆順に生成する。（要素が重複していてもOK）
全候補を試したい場合は、事前にスライスをソートしておく。
ex:

	for {
		// aの処理

		if !prev_permutation(a) {
			break
		}
	}
*/
func prev_permutation(a []int) bool {
	// a[l] > a[l+1]を満たす最大のlを求める
	l, n := -1, len(a)
	for i := n - 2; i >= 0; i-- {
		if a[i] > a[i+1] {
			l = i
			break
		}
	}

	if l == -1 {
		sort.Ints(a)
		reverse(a)
		return false
	}

	// a[l] > a[r]を満たす最大のrを求める
	r := len(a) - 1
	for a[l] <= a[r] {
		r--
	}

	a[l], a[r] = a[r], a[l]
	// [l+1,n-1]が降順なので逆順にする
	for i := l + 1; i <= (l+len(a))/2; i++ {
		a[i], a[len(a)-(i-l)] = a[len(a)-(i-l)], a[i]
	}

	return true
}

func swap[T any](a, b *T) {
	*a, *b = *b, *a
}

type rle[t constraints.Ordered] struct {
	v t
	n int
}

// ランレングス圧縮
func run_length_encoding[t constraints.Ordered](s []t) []rle[t] {
	n := len(s)
	res := make([]rle[t], 0)

	l := 0
	for l < n {
		c := s[l]
		r := l
		for r < n && s[r] == c {
			r++
		}

		res = append(res, rle[t]{v: c, n: r - l})

		l = r
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

/*
単調増加部分列の長さを返す
strict = falseのとき、同じ値が連続することを許す
*/
func lis(a []int, strict bool) int {
	dp := make([]int, len(a))
	for i := 0; i < len(a); i++ {
		dp[i] = INF
	}

	for i := 0; i < len(a); i++ {
		var it int
		if strict {
			it = lowerBound(dp, a[i])
		} else {
			it = upperBound(dp, a[i])
		}
		dp[it] = a[i]
	}

	return lowerBound(dp, INF)
}

// 最大公約数を取得
func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}

// 最小公倍数を取得
func lcm(a, b int) int {
	return a / gcd(a, b) * b
}

// nを素因数分解 => map[素因数]個数
func factorize(n int) map[int]int {
	result := make(map[int]int)

	for i := 2; i*i <= n; i++ {
		if n%i != 0 {
			continue
		}

		result[i] = 0
		for n%i == 0 {
			result[i]++
			n /= i
		}
	}

	if n != 1 {
		result[n] = 1
	}

	return result
}

// エラトステネスの篩
func eratosu(n int) []bool {
	isprime := make([]bool, n)
	for i := 0; i < n; i++ {
		isprime[i] = true
	}

	for i := 2; i*i < n; i++ {
		if isprime[i] {
			for j := i * 2; j < n; j += i {
				isprime[j] = false
			}
		}
	}

	return isprime
}

// 素数列挙
func primes(n int) []int {
	isprime := eratosu(n + 1)

	res := make([]int, 0)
	for i := 2; i <= n; i++ {
		if isprime[i] {
			res = append(res, i)
		}
	}

	return res
}

// 素数判定
func isprime(n int) bool {
	for i := 2; i*i <= n; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

// 約数列挙
func divisors(n int) []int {
	res := make([]int, 0)
	for i := 1; i*i <= n; i++ {
		if n%i != 0 {
			continue
		}
		res = append(res, i)
		if i != n/i {
			res = append(res, n/i)
		}
	}
	sort.Ints(res)
	return res
}

func max[T constraints.Ordered](vs ...T) T {
	result := vs[0]
	for i := 0; i < len(vs); i++ {
		if result < vs[i] {
			result = vs[i]
		}
	}
	return result
}

func min[T constraints.Ordered](vs ...T) T {
	result := vs[0]
	for i := 0; i < len(vs); i++ {
		if result > vs[i] {
			result = vs[i]
		}
	}
	return result
}

func chmax[T constraints.Ordered](x *T, y T) {
	*x = max(*x, y)
}

func chmin[T constraints.Ordered](x *T, y T) {
	*x = min(*x, y)
}

func abs[T constraints.Integer | constraints.Float](x T) T {
	return max(x, -x)
}

func reverseString(s string) string {
	res := []rune(s)
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		res[i], res[j] = res[j], res[i]
	}
	return string(res)
}

func reverse[T any](x []T) {
	for i := 0; i < len(x)/2; i++ {
		x[i], x[len(x)-1-i] = x[len(x)-1-i], x[i]
	}
}

// 重複を削除したスライスを返す
func uniq[T constraints.Ordered](x []T) []T {
	mp := make(map[T]bool)

	res := make([]T, 0)
	for i := 0; i < len(x); i++ {
		if mp[x[i]] {
			continue
		}

		mp[x[i]] = true
		res = append(res, x[i])
	}

	return res
}

// 座標圧縮: [3,1,5,2] -> [2,0,3,1]
func compress(a []int) []int {
	uq := uniq(a)
	sort.Ints(uq)

	n := len(a)
	res := make([]int, n)
	for i := 0; i < n; i++ {
		res[i] = lowerBound(uq, a[i])
	}

	return res
}

func sqrt(x int) int {
	return int(math.Sqrt(float64(x)))
}

func ceil(a, b int) int {
	return (a + b - 1) / b
}

type grid struct {
	h, w  int
	datas [][]string
}

type point struct {
	i, j int
}

func newGrid(h, w int) *grid {
	res := &grid{h, w, make([][]string, h)}

	for i := 0; i < h; i++ {
		res.datas[i] = strings.Split(ns(), "")
	}

	return res
}

func (g *grid) bfs(starts []point) [][]int {
	dists := make([][]int, g.h)
	q := make([]point, 0)

	for i := 0; i < g.h; i++ {
		dists[i] = make([]int, g.w)
		for j := 0; j < g.w; j++ {
			dists[i][j] = INF
		}
	}
	for _, s := range starts {
		dists[s.i][s.j] = 0
		q = append(q, point{s.i, s.j})
	}

	di, dj := dij()
	for len(q) > 0 {
		now := q[0]
		q = q[1:]

		for i := 0; i < 4; i++ {
			ni, nj := now.i+di[i], now.j+dj[i]
			if ni < 0 || nj < 0 || ni >= g.h || nj >= g.w {
				continue
			}
			if dists[ni][nj] != INF {
				continue
			}
			if g.datas[ni][nj] != "#" {
				continue
			}

			dists[ni][nj] = dists[now.i][now.j] + 1
			q = append(q, point{ni, nj})
		}
	}

	return dists
}

type edge struct {
	// 頂点
	v int

	// コスト
	c int
}

type graph struct {
	// 隣接リスト
	datas map[int][]edge

	// 重さがあるか
	weighted bool

	// 辺に向きがあるか
	directed bool
}

/*
グラフの構築
入力に辺情報が与えられる場合のみmに辺数を指定する(それ以外は0を入れる)
有向辺の場合はdirectedをtrueに、そうでない場合falseを指定する
*/
func newGraph(m int, weighted, directed bool) *graph {
	g := &graph{make(map[int][]edge), weighted, directed}

	if m == 0 {
		return g
	}

	for i := 0; i < m; i++ {
		u, v, c := ni()-1, ni()-1, 1
		if weighted {
			c = ni()
		}
		g.addEdge(u, v, c)
	}

	return g
}

// グラフに辺を追加する
func (g *graph) addEdge(u, v, c int) {
	g.datas[u] = append(g.datas[u], edge{v, c})
	if !g.directed {
		g.datas[v] = append(g.datas[v], edge{u, c})
	}
}

// priorityqueue用にコストの昇順にソートするcomparatorを作成
func (g *graph) dijkstraComparator(a, b edge) int {
	if a.c == b.c {
		return 0
	} else if a.c < b.c {
		return -1
	} else {
		return 1
	}
}

// ダイクストラを実行して始点からの最短距離を取得
func (g *graph) dijkstra(starts map[int]int) map[int]int {
	dists := make(map[int]int)

	for node := range g.datas {
		dists[node] = INF
	}
	for v, c := range starts {
		dists[v] = c
	}

	q := priorityqueue.New(g.dijkstraComparator)
	for v, c := range starts {
		q.Push(edge{v, c})
	}
	for q.Size() > 0 {
		cur := q.Pop()

		if cur.c != dists[cur.v] {
			continue
		}

		for _, e := range g.datas[cur.v] {
			newDist := cur.c + e.c
			if newDist < dists[e.v] {
				dists[e.v] = newDist
				q.Push(edge{e.v, newDist})
			}
		}
	}

	return dists
}

type unionfind struct {
	// par[x]: 要素 x の親頂点の番号 (自身が根の場合は −1)
	// rank[x]: 要素 x の属する根付き木の高さ
	// siz[x]: 要素 x の属する根付き木に含まれる頂点数
	// diff_weight[x]: 要素 x の親ノードとの値の差分
	par, rank, siz, diff_weight []int
}

func newUnionFind(n int) *unionfind {
	result := new(unionfind)
	result.par, result.rank, result.siz, result.diff_weight = make([]int, n), make([]int, n), make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		result.par[i] = -1
		result.rank[i] = 0
		result.siz[i] = 1
		result.diff_weight[i] = 0
	}
	return result
}

// ノード x のグループID を取得
func (u *unionfind) root(x int) int {
	if u.par[x] == -1 {
		return x
	}
	// 経路圧縮
	rx := u.root(u.par[x])
	u.diff_weight[x] += u.diff_weight[u.par[x]]
	u.par[x] = rx
	return rx
}

// ノード x とノード y が同じグループに存在するか判定
func (u *unionfind) same(x, y int) bool {
	return u.root(x) == u.root(y)
}

// weight(y) - weight(x) = w となるように merge する
func (u *unionfind) unite(x, y, w int) bool {
	rx, ry := u.root(x), u.root(y)
	if rx == ry {
		return false
	}

	w += u.weight(x) - u.weight(y)

	// union by rank
	if u.rank[x] < u.rank[y] {
		rx, ry = ry, rx
		w = -w
	}
	u.par[ry] = rx
	if u.rank[rx] == u.rank[ry] {
		u.rank[rx]++
	}
	u.siz[rx] += u.siz[ry]

	// rx が ry の親になるので diff_weight[ry]を更新
	u.diff_weight[ry] = w

	return true
}

// ノード x の重みを取得
func (u *unionfind) weight(x int) int {
	u.root(x)
	return u.diff_weight[x]
}

// ノード x を基準にしたときのノード y の重みを取得
func (u *unionfind) diff(x, y int) int {
	return u.weight(y) - u.weight(x)
}

// ノード x が含まれるグループのサイズを取得
func (u *unionfind) size(x int) int {
	return u.siz[u.root(x)]
}

type mint int

func (m mint) add(n int) mint {
	n = n % MOD
	return mint(int(m) + n).mod()
}

func (m mint) sub(n int) mint {
	return mint(int(m) - n + MOD).mod()
}

func (m mint) mul(n int) mint {
	n = n % MOD
	// m.mod(): オーバーフロー対策
	return mint(int(m.mod()) * n).mod()
}

func (m mint) div(n int) mint {
	n = n % MOD
	d := inv(n)
	return m.mul(d).mod()
}

func (m mint) mod() mint {
	return mint((int(m) + MOD) % MOD)
}

func inv(n int) int {
	return mpow(n, MOD-2, MOD)
}

func mpow(a, b, p int) int {
	if b == 0 {
		return 1
	}

	t := mpow(a, b/2, p)
	if b%2 == 0 {
		return (t * t) % p
	} else {
		return (((t * t) % p) * a) % p
	}
}

func combination(n int, k int) int {
	if n < k || n < 0 || k < 0 {
		return 0
	}
	if n-k < k {
		k = n - k
	}
	v := 1
	for i := 0; i < k; i++ {
		v *= (n - i)
		v /= (i + 1)
	}
	return v
}

func modcombination(n int, k int) int {
	if n < k || n < 0 || k < 0 {
		return 0
	}
	v := mint(1)
	for i := 0; i < k; i++ {
		v = v.mul(n - i).div(i + 1)
	}
	return int(v)
}

type modcomb struct {
	n          int
	factorizes []int
}

func newModcomb(n int) *modcomb {
	factorizes := make([]int, n+1)
	factorizes[0] = 1
	for i := 1; i <= n; i++ {
		factorizes[i] = (factorizes[i-1] * i) % MOD
	}

	return &modcomb{n: n, factorizes: factorizes}
}

func (m *modcomb) combination(n, k int) int {
	if n < k || n < 0 || k < 0 {
		return 0
	}
	result := mint(m.factorizes[n]).div(m.factorizes[k]).div(m.factorizes[n-k])
	return int(result)
}

// Range XOR Query
type rxq struct {
	n     int   // 元データの要素数以上の2冪の最下段の要素数に対応するサイズ.
	nodes []int // セグ木を構成するデータリスト.
}

// RXQ初期化
func newRXQ(vs []int) *rxq {
	n := 1
	for n < len(vs) {
		n *= 2
	}

	res := &rxq{n: n, nodes: make([]int, 2*n-1)}
	for i := 0; i < len(vs); i++ {
		res.nodes[n-1+i] = vs[i]
	}
	for i := n - 2; i >= 0; i-- {
		res.nodes[i] = res.nodes[2*i+1] ^ res.nodes[2*i+2]
	}

	return res
}

// n番目の要素をvに更新
func (seg *rxq) update(n, v int) {
	n += seg.n - 1

	seg.nodes[n] = v
	for n != 0 {
		n = (n - 1) / 2
		seg.nodes[n] = seg.nodes[2*n+1] ^ seg.nodes[2*n+2]
	}
}

// 区間[x,y)の要素のxor和を取得
func (seg *rxq) query(x, y int) int {
	return seg.getsum(x, y, 0, 0, seg.n)
}

/*
要求区間 [x, y) 中の要素のxor和を取得
k := 自分がいるノードのインデックス
対象区間は [l, r) にあたる
*/
func (seg *rxq) getsum(x, y, k, l, r int) int {
	if y <= l || r <= x {
		return 0
	} else if x <= l && r <= y {
		return seg.nodes[k]
	} else {
		mid := (l + r) / 2
		lv, rv := seg.getsum(x, y, 2*k+1, l, mid), seg.getsum(x, y, 2*k+2, mid, r)
		return lv ^ rv
	}
}

// 遅延評価セグメント木
type lazySegmentTree struct {
	n              int
	node, lazy     []int
	fx, fa, fm, fp func(a, b int) int
	ex, em         int
}

type lazySegmentTreeOption struct{}

func (m *lazySegmentTreeOption) sum(a, b int) int {
	return a + b
}

func (m *lazySegmentTreeOption) min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func (m *lazySegmentTreeOption) max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func (m *lazySegmentTreeOption) change(_, b int) int {
	return b
}

func (m *lazySegmentTreeOption) fp(a, b int) int {
	return a * b
}

func (m *lazySegmentTreeOption) nofp(a, _ int) int {
	return a
}

// 遅延評価セグメント木の構築
func newLazySegmentTree(vs []int, fx, fa, fm, fp func(a, b int) int, ex, em int) *lazySegmentTree {
	n := 1
	for n < len(vs) {
		n *= 2
	}

	node, lazy := make([]int, 2*n-1), make([]int, 2*n-1)
	for i := 0; i < 2*n-1; i++ {
		node[i] = ex
		lazy[i] = em
	}
	for i := 0; i < len(vs); i++ {
		node[n-1+i] = vs[i]
	}
	for i := n - 2; i >= 0; i-- {
		node[i] = fx(node[i*2+1], node[i*2+2])
	}

	return &lazySegmentTree{n, node, lazy, fx, fa, fm, fp, ex, em}
}

// 区間[a,b)にxだけ更新を行う
func (m *lazySegmentTree) update(a, b, x int) {
	m.update_sub(a, b, x, 0, 0, m.n)
}

// 区間[a,b)の取得を行う
func (m *lazySegmentTree) query(a, b int) int {
	return m.query_sub(a, b, 0, 0, m.n)
}

// 遅延評価
func (m *lazySegmentTree) eval(k, l, r int) {
	if m.lazy[k] == m.em {
		return
	}

	if r-l > 1 {
		m.lazy[2*k+1] = m.fm(m.lazy[2*k+1], m.lazy[k])
		m.lazy[2*k+2] = m.fm(m.lazy[2*k+2], m.lazy[k])
	}

	m.node[k] = m.fa(m.node[k], m.fp(m.lazy[k], r-l))

	m.lazy[k] = m.em
}

/*
内部データの区間にxだけ更新を行う
区間[a,b): 要求区間(クエリで与えられる区間)
区間[l,r): 対象区間(自ノードが管理する区間)
*/
func (m *lazySegmentTree) update_sub(a, b, x, k, l, r int) {
	m.eval(k, l, r)

	// 範囲外
	if b <= l || r <= a {
		return
	}

	// 完全に被覆している
	if a <= l && r <= b {
		m.lazy[k] = m.fm(m.lazy[k], x)
		m.eval(k, l, r)
		return
	}

	// それ以外
	m.update_sub(a, b, x, 2*k+1, l, (l+r)/2)
	m.update_sub(a, b, x, 2*k+2, (l+r)/2, r)
	m.node[k] = m.fx(m.node[2*k+1], m.node[2*k+2])
}

/*
内部データから区間取得する
区間[a,b): 要求区間(クエリで与えられる区間)
区間[l,r): 対象区間(自ノードが管理する区間)
*/
func (m *lazySegmentTree) query_sub(a, b, k, l, r int) int {
	m.eval(k, l, r)

	// 範囲外
	if b <= l || r <= a {
		return m.ex
	}

	// 完全に被覆している
	if a <= l && r <= b {
		return m.node[k]
	}

	// それ以外
	vl := m.query_sub(a, b, 2*k+1, l, (l+r)/2)
	vr := m.query_sub(a, b, 2*k+2, (l+r)/2, r)
	return m.fx(vl, vr)
}
