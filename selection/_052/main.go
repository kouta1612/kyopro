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

func main() {
	sc.Split(bufio.ScanWords)

	n, m := scanInt(), scanInt()

	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = scanInt() - 1
	}

	sum := make([][]int, m)
	for i := 0; i < m; i++ {
		sum[i] = make([]int, n+1)
	}
	for i := 0; i < n; i++ {
		sum[a[i]][i+1]++
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			sum[i][j+1] += sum[i][j]
		}
	}

	ssum := make([]int, 1<<m)
	for i := 0; i < 1<<m; i++ {
		for j := 0; j < m; j++ {
			if i&(1<<j) > 0 {
				ssum[i] += sum[j][n]
			}
		}
	}

	// dp[s]: 整列済のぬいぐるみの種類がsの集合のとき取り出すぬいぐるみの最小回数
	// dp[s] → dp[s|i] (i: sに含まれないぬいぐるみの種類)
	dp := make([]int, 1<<m)
	for i := 0; i < 1<<m; i++ {
		dp[i] = INF
	}
	dp[0] = 0

	for i := 0; i < 1<<m; i++ {
		for j := 0; j < m; j++ {
			if (i & (1 << m)) > 0 {
				continue
			}

			l, r := ssum[i], ssum[i|(1<<j)]
			dp[i|(1<<j)] = min(dp[i|(1<<j)], dp[i]+(r-l-(sum[j][r]-sum[j][l])))
		}
	}

	fmt.Println(dp[(1<<m)-1])
}
