package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, 21)
	}

	dp[1][a[0]] = 1
	for i := 2; i < n; i++ {
		for j := 0; j <= 20; j++ {
			if j-a[i-1] >= 0 {
				dp[i][j] += dp[i-1][j-a[i-1]]
			}
			if j+a[i-1] <= 20 {
				dp[i][j] += dp[i-1][j+a[i-1]]
			}
		}
	}

	fmt.Println(dp[n-1][a[n-1]])
}
