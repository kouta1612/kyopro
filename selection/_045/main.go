package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

func min(a, b int) int {
	return int(math.Min(float64(a), float64(b)))
}

const INF = int(1e12)

func main() {
	sc.Split(bufio.ScanWords)

	results := make([]int, 0)

	for {
		n, m := scanInt(), scanInt()

		if n == 0 && m == 0 {
			break
		}

		c := make([]int, m)
		x := make([]int, n)
		for i := 0; i < m; i++ {
			c[i] = scanInt()
		}
		for i := 0; i < n; i++ {
			x[i] = scanInt()
		}

		dp := make([][]int, n+1)
		for i := 0; i < n+1; i++ {
			dp[i] = make([]int, 256)
			for j := 0; j < 256; j++ {
				dp[i][j] = INF
			}
		}
		dp[0][128] = 0

		// dp[i][j]: i個目の入力信号x[i-1]と出力信号jのときのi個目の入力信号までのデータ差の2乗和の最小値
		// dp[i][j] → dp[i+1][l] (0 <= l <= 255, l = j + c[k], k: 0-indexed k番目のコードブック)
		for i := 0; i < n; i++ {
			for j := 0; j < 256; j++ {
				for k := 0; k < m; k++ {
					if dp[i][j] == INF {
						continue
					}

					l := j + c[k]
					l = max(min(l, 255), 0)
					dp[i+1][l] = min(dp[i+1][l], dp[i][j]+(x[i]-l)*(x[i]-l))
				}
			}
		}

		result := INF
		for i := 0; i < len(dp[n]); i++ {
			result = min(result, dp[n][i])
		}

		results = append(results, result)
	}

	for i := 0; i < len(results); i++ {
		fmt.Println(results[i])
	}
}
