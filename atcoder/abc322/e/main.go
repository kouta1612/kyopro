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
		if dp[i+1] == nil {
			dp[i+1] = make(map[[5]int]int)
		}
		for status, cost := range dp[i] {
			// 選ばない場合（TODO: ここで場合分けする理由を理解する）
			if dp[i+1][status] == 0 {
				dp[i+1][status] = cost
			} else {
				dp[i+1][status] = int(math.Min(float64(dp[i+1][status]), float64(cost)))
			}

			// 選ぶ場合
			nextStatus := status
			for j := 0; j < k; j++ {
				nextStatus[j] = int(math.Min(float64(p), float64(nextStatus[j]+a[i][j])))
			}
			if savedCost, exist := dp[i][nextStatus]; exist {
				if dp[i+1][nextStatus] == 0 {
					dp[i+1][nextStatus] = int(math.Min(float64(savedCost), float64(cost+c[i])))
				} else {
					dp[i+1][nextStatus] = int(math.Min(math.Min(float64(dp[i+1][nextStatus]), float64(savedCost)), float64(cost+c[i])))
				}
			} else {
				// （TODO: ここで場合分けする理由を理解する）
				if dp[i+1][nextStatus] == 0 {
					dp[i+1][nextStatus] = cost + c[i]
				} else {
					dp[i+1][nextStatus] = int(math.Min(float64(dp[i+1][nextStatus]), float64(cost+c[i])))
				}
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
