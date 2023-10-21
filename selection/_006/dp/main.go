package main

import "fmt"

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	dp := make([][][]bool, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([][]bool, 4)
		for j := 0; j < 4; j++ {
			dp[i][j] = make([]bool, 1001)
		}
	}
	dp[0][0][0] = true

	for i := 0; i < n; i++ {
		for j := 0; j < 4; j++ {
			for k := 0; k < 1000; k++ {
				if !dp[i][j][k] {
					continue
				}

				dp[i+1][j][k] = true

				if j > 2 {
					continue
				}

				dp[i+1][j+1][k*10+int(s[i]-'0')] = true
			}
		}
	}

	result := 0
	for i := 0; i < 1000; i++ {
		if dp[n][3][i] {
			result++
		}
	}

	fmt.Println(result)
}
