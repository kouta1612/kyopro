package main

import (
	"fmt"
	"math"
)

func main() {
	var n, k, p int
	fmt.Scan(&n, &k, &p)

	c := make([]int, n)
	a := make([][]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&c[i])

		a[i] = make([]int, k)
		for j := 0; j < k; j++ {
			fmt.Scan(&a[i][j])
		}
	}

	dp := make([]map[[5]int]int, n+1)
	// ここはより良い方法ないか探る
	dp[0] = map[[5]int]int{{0, 0, 0, 0, 0}: 0}
	for i := 0; i < n; i++ {
		dp[i+1] = copyMap(dp[i])
		for status := range dp[i] {
			nextStatus := status
			for j := 0; j < k; j++ {
				nextStatus[j] = int(math.Min(float64(p), float64(nextStatus[j]+a[i][j])))
			}
			if cost, exist := dp[i+1][nextStatus]; exist {
				dp[i+1][nextStatus] = int(math.Min(float64(cost), float64(dp[i][status]+c[i])))
			} else {
				dp[i+1][nextStatus] = dp[i][status] + c[i]
			}
		}
	}

	// ここはより良い方法ないか探る
	searchStatus := [5]int{p, p, p, p, p}
	for i := k; i < 5; i++ {
		searchStatus[i] = 0
	}

	if dp[n][searchStatus] == 0 {
		fmt.Println(-1)
	} else {
		fmt.Println(dp[n][searchStatus])
	}
}

func copyMap(input map[[5]int]int) map[[5]int]int {
	result := make(map[[5]int]int)
	for i, v := range input {
		result[i] = v
	}
	return result
}
