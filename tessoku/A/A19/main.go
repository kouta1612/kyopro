package main

import (
	"fmt"
	"math"
)

func main() {
	var N, W int
	fmt.Scan(&N, &W)

	w := make([]int, N)
	v := make([]int64, N)
	for i := 0; i < N; i++ {
		fmt.Scan(&w[i], &v[i])
	}

	dp := make([][]int64, N+1)
	for i := 0; i <= N; i++ {
		dp[i] = make([]int64, W+1)
	}

	for i := 0; i <= N; i++ {
		for j := 0; j <= W; j++ {
			dp[i][j] = -int64(math.Pow10(11))
		}
	}
	dp[0][0] = 0

	for i := 1; i <= N; i++ {
		for j := 0; j <= W; j++ {
			if j-w[i-1] >= 0 {
				dp[i][j] = int64(math.Max(float64(dp[i-1][j-w[i-1]]+v[i-1]), float64(dp[i-1][j])))
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	var result int64
	for i := 0; i <= W; i++ {
		result = int64(math.Max(float64(result), float64(dp[N][i])))
	}

	fmt.Println(result)
}
