package main

import "fmt"

func main() {
	var n, s int
	fmt.Scan(&n, &s)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	dp := make([][]bool, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]bool, 600001)
	}
	dp[0][0] = true

	for i := 1; i < n+1; i++ {
		for j := 0; j < 600001; j++ {
			if j-a[i-1] >= 0 && dp[i-1][j-a[i-1]] {
				dp[i][j] = true
			}
			if dp[i-1][j] {
				dp[i][j] = true
			}
		}
	}

	if dp[n][s] {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
