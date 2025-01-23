package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const (
	INF = 1 << 60
	MOD = int(1e9) + 7
)

var sc = bufio.NewScanner(os.Stdin)
var out = bufio.NewWriter(os.Stdout)

func main() {
	defer out.Flush()

	n, q := ni2()
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = 1<<31 - 1
	}

	seg := newLazySegmentTree(a, min_, change, change, no, 1<<31-1, 1<<31-1)
	for qi := 0; qi < q; qi++ {
		t := ni()
		if t == 0 {
			s, t, x := ni3()
			seg.update(s, t+1, x)
		} else {
			s, t := ni2()
			fmt.Println(seg.query(s, t+1))
		}
	}
}

// 遅延評価セグメント木
type lazySegmentTree struct {
	n              int
	node, lazy     []int
	fx, fa, fm, fp func(a, b int) int
	ex, em         int
}

func sum(a, b int) int {
	return a + b
}

func prod(a, b int) int {
	return a * b
}

func min_(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func change(a, b int) int {
	return b
}

func no(a, b int) int {
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
