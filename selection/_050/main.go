package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e18)

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
	t, d, time int
}

type result struct {
	d, t int
}

func main() {
	sc.Split(bufio.ScanWords)

	n, m := scanInt(), scanInt()

	g := make([][]edge, n)
	for i := 0; i < n; i++ {
		g[i] = make([]edge, 0)
	}
	for i := 0; i < m; i++ {
		s, t, d, time := scanInt()-1, scanInt()-1, scanInt(), scanInt()
		g[s] = append(g[s], edge{t: t, d: d, time: time})
		g[t] = append(g[t], edge{t: s, d: d, time: time})
	}

	dp := make([][]result, 1<<n)
	for i := 0; i < 1<<n; i++ {
		dp[i] = make([]result, n)
		for j := 0; j < n; j++ {
			dp[i][j] = result{d: INF, t: 0}
		}
	}
	dp[0][0] = result{d: 0, t: 1}

	// dp[s][v]: 現時点で辿った地点の集合sで現時点の地点がvであるときの最短経路と最短時間
	for s := 0; s < 1<<n; s++ {
		for v := 0; v < n; v++ {
			if v != 0 && (s&(1<<v)) == 0 {
				continue
			}
			for _, edge := range g[v] {
				if dp[s][v].d+edge.d > edge.time {
					continue
				}
				if (s & (1 << edge.t)) > 0 {
					continue
				}

				if dp[s][v].d+edge.d < dp[s|(1<<edge.t)][edge.t].d {
					dp[s|(1<<edge.t)][edge.t] = result{d: dp[s][v].d + edge.d, t: dp[s][v].t}
				} else if dp[s][v].d+edge.d == dp[s|(1<<edge.t)][edge.t].d {
					dp[s|(1<<edge.t)][edge.t] = result{d: dp[s][v].d + edge.d, t: dp[s][v].t + dp[s|(1<<edge.t)][edge.t].t}
				}
			}
		}
	}

	if dp[(1<<n)-1][0].d != INF {
		fmt.Println(dp[(1<<n)-1][0].d, dp[(1<<n)-1][0].t)
	} else {
		fmt.Println("IMPOSSIBLE")
	}
}
