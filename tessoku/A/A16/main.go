package main

import (
	"fmt"
	"math"
)

func main() {
	var n int
	fmt.Scan(&n)

	a := make([]int, n)
	b := make([]int, n)
	for i := 1; i < n; i++ {
		fmt.Scan(&a[i])
	}
	for i := 2; i < n; i++ {
		fmt.Scan(&b[i])
	}

	dp := make([]int, n)
	for i := 1; i < n; i++ {
		dp[i] = dp[i-1] + a[i]
		if i >= 2 {
			dp[i] = int(math.Min(float64(dp[i]), float64(dp[i-2]+b[i])))
		}
	}

	fmt.Println(dp[n-1])
}
