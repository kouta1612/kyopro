package main

import (
	"fmt"
	"math"
)

func main() {
	var N, W int
	fmt.Scan(&N, &W)

	v, w := make([]int, N), make([]int, N)
	for i := 0; i < N; i++ {
		fmt.Scan(&v[i], &w[i])
	}

	dp := make([][]int, N+1)
	for i := 0; i < N+1; i++ {
		dp[i] = make([]int, W+1)
	}

	for i := 1; i <= N; i++ {
		for j := 1; j <= W; j++ {
			if j-w[i-1] >= 0 {
				dp[i][j] = int(math.Max(float64(dp[i-1][j]), float64(dp[i][j-w[i-1]]+v[i-1])))
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	fmt.Println(dp[N][W])
}
