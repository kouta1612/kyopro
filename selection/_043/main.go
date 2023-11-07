package main

import (
	"fmt"
	"math"
	"strings"
)

const INF = 5000

func main() {
	var n int
	fmt.Scan(&n)

	s := make([][]string, 5)
	for i := 0; i < 5; i++ {
		s[i] = make([]string, n)

		var t string
		fmt.Scan(&t)

		s[i] = strings.Split(t, "")
	}

	m := []string{"R", "B", "W"}

	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, len(m))
		for j := 0; j < len(m); j++ {
			dp[i][j] = INF
		}
	}
	for i := 0; i < len(m); i++ {
		dp[0][i] = 0
	}

	// dp[i][j]: i列目まで処理したときの0-indexedにおけるi-1列目の色をすべてjに塗り替えたマスの合計の最小値
	// dp[i][j] → d[i+1][jと3以外]
	for i := 0; i < n; i++ {
		for j := 0; j < len(m); j++ {
			for k := 0; k < len(m); k++ {
				if m[k] == m[j] {
					continue
				}

				cnt := 0
				for l := 0; l < 5; l++ {
					if m[k] != s[l][i] {
						cnt++
					}
				}

				dp[i+1][k] = int(math.Min(float64(dp[i+1][k]), float64(dp[i][j]+cnt)))
			}
		}
	}

	result := INF
	for i := 0; i < 3; i++ {
		result = int(math.Min(float64(result), float64(dp[n][i])))
	}

	fmt.Println(result)
}
