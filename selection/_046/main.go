package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e9)

var sc = bufio.NewScanner(os.Stdin)

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

func min(a, b int) int {
	return int(math.Min(float64(a), float64(b)))
}

func main() {
	sc.Split(bufio.ScanWords)

	n := scanInt()

	r, c, p := make([]int, n), make([]int, n), make([]int, 0)
	for i := 0; i < n; i++ {
		r[i], c[i] = scanInt(), scanInt()

		if i == 0 {
			p = append(p, r[i])
		}

		p = append(p, c[i])
	}

	// dp[i][j]: iからj番目までの行列連鎖の演算に必要な最小回数
	// dp[i][j] ← chmin(dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j]) (i <= k < j)
	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, n+1)
		for j := 0; j < n+1; j++ {
			dp[i][j] = INF
		}
	}
	for i := 0; i < n+1; i++ {
		dp[i][i] = 0
	}

	for l := 2; l <= n; l++ {
		for i := 1; i <= n; i++ {
			j := i + l - 1
			if j > n {
				continue
			}

			for k := i; k < j; k++ {
				dp[i][j] = min(dp[i][j], dp[i][k]+dp[k+1][j]+p[i-1]*p[k]*p[j])
			}
		}
	}

	fmt.Println(dp[1][n])
}
