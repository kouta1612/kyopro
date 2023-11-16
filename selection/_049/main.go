package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
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

type edge struct {
	t, d int
}

const INF = 20000

func main() {
	sc.Split(bufio.ScanWords)

	v, e := scanInt(), scanInt()
	g := make([][]edge, v)
	for i := 0; i < v; i++ {
		g[i] = make([]edge, 0)
	}
	for i := 0; i < e; i++ {
		s, t, d := scanInt(), scanInt(), scanInt()
		g[s] = append(g[s], edge{t: t, d: d})
	}

	dp := make([][]int, 1<<uint(v))
	for i := 0; i < 1<<uint(v); i++ {
		dp[i] = make([]int, v)
		for j := 0; j < v; j++ {
			dp[i][j] = INF
		}
	}
	dp[0][0] = 0

	// dp[b][i]: 今までに通った頂点が集合bで頂点iにいる時の最短経路の長さ
	// dp[b][i] → dp[b|k][k] (k: iの隣接頂点で0~i-1)
	for b := 0; b < 1<<uint(v); b++ {
		for i := 0; i < v; i++ {
			if i != 0 && b&(1<<uint(i)) == 0 {
				continue
			}

			for _, ne := range g[i] {
				if (b & (1 << uint(ne.t))) > 0 {
					continue
				}
				dp[b|(1<<uint(ne.t))][ne.t] = min(dp[b|(1<<uint(ne.t))][ne.t], dp[b][i]+ne.d)
			}
		}
	}

	if dp[1<<uint(v)-1][0] == INF {
		fmt.Println(-1)
	} else {
		fmt.Println(dp[1<<uint(v)-1][0])
	}
}
