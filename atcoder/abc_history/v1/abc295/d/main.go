package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"

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

	s := ns()
	n := len(s)

	x := make([]int, n+1)
	for i := 0; i < n; i++ {
		c := s[i] - '0'
		x[i+1] = x[i] ^ 1<<c
	}

	freq := make(map[int]int)
	for i := 0; i < n+1; i++ {
		freq[x[i]]++
	}

	ans := 0
	for _, v := range freq {
		ans += v * (v - 1) / 2
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

func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}

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
	return mint(int(m) * n).mod()
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
