package main

import (
	"fmt"
	"math"
)

func main() {
	var d, n int
	fmt.Scan(&d, &n)

	t, a, b, c := make([]int, d), make([]int, n), make([]int, n), make([]int, n)
	for i := 0; i < d; i++ {
		fmt.Scan(&t[i])
	}
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i], &b[i], &c[i])
	}

	dp := make([][]int, d+1)
	for i := 0; i < d+1; i++ {
		dp[i] = make([]int, n)
	}

	// dp[i][j]: i日間まででi-1日目に服jを着るときの派手さの合計
	// dp[i][j] → dp[i+1][k] (k:0~n-1)
	for i := 1; i < d; i++ {
		for j := 0; j < n; j++ {
			for k := 0; k < n; k++ {
				if !(a[j] <= t[i-1] && t[i-1] <= b[j]) {
					continue
				}
				if !(a[k] <= t[i] && t[i] <= b[k]) {
					continue
				}

				dp[i+1][k] = int(math.Max(float64(dp[i+1][k]), float64(dp[i][j]+int(math.Abs(float64(c[j]-c[k]))))))
			}
		}
	}

	result := 0
	for i := 0; i < len(dp[d]); i++ {
		result = int(math.Max(float64(result), float64(dp[d][i])))
	}

	fmt.Println(result)
}
