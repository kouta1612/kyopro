package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e16)

var sc = bufio.NewScanner(os.Stdin)

func main() {
	sc.Split(bufio.ScanWords)

	v, e := scanInt(), scanInt()
	g := make([][]int, v)
	for i := 0; i < v; i++ {
		g[i] = make([]int, v)
		for j := 0; j < v; j++ {
			if i == j {
				continue
			}

			g[i][j] = INF
		}
	}
	for i := 0; i < e; i++ {
		s, t, d := scanInt(), scanInt(), scanInt()
		g[s][t] = d
	}

	for k := 0; k < v; k++ {
		for i := 0; i < v; i++ {
			for j := 0; j < v; j++ {
				if g[i][k] == INF || g[k][j] == INF {
					continue
				}

				g[i][j] = min(g[i][j], g[i][k]+g[k][j])
				if i == j && g[i][j] != 0 {
					fmt.Println("NEGATIVE CYCLE")
					return
				}
			}
		}
	}

	for i := 0; i < v; i++ {
		for j := 0; j < v; j++ {
			if g[i][j] == INF {
				if j == v-1 {
					fmt.Print("INF")
				} else {
					fmt.Print("INF", " ")
				}
			} else {
				if j == v-1 {
					fmt.Print(g[i][j])
				} else {
					fmt.Print(g[i][j], " ")
				}
			}
		}
		fmt.Println()
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

func sqrt(x int) int {
	return int(math.Sqrt(float64(x)))
}
