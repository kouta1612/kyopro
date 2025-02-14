package main

func main() {}

type fenwick struct {
	datas []int
}

func newFenwick(n int) *fenwick {
	// 内部では1-indexedで扱うためn+1サイズで初期化
	return &fenwick{datas: make([]int, n+1)}
}

func (m *fenwick) add(a, x int) {
	n := len(m.datas)
	for i := a + 1; i < n; i += i & -i {
		m.datas[i] += x
	}
}

// [0,a)の総和を取得する
func (m *fenwick) sum(a int) int {
	res := 0
	for i := a; i > 0; i -= i & -i {
		res += m.datas[i]
	}
	return res
}
