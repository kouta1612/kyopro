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

func min(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Min(float64(res), float64(v)))
	}

	return res
}

func max(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Max(float64(res), float64(v)))
	}

	return res
}

func abs(a int) int {
	return int(math.Abs(float64(a)))
}

func main() {
	sc.Split(bufio.ScanWords)
	results := []int{}

	for {
		n := scanInt()
		if n == 0 {
			break
		}

		w := make([]int, n)
		for i := 0; i < n; i++ {
			w[i] = scanInt()
		}

		dp := make([][]int, n)
		for i := 0; i < n; i++ {
			dp[i] = make([]int, n)
		}
		for i := 0; i < n-1; i++ {
			if abs(w[i]-w[i+1]) <= 1 {
				dp[i][i+1] = 2
			}
		}

		// dp[i][j]: [i,j]で取り除くことができるブロックの最大個数
		// dp[i][j] ← dp[i+1][j-1] + 2
		// dp[i][j] ← dp[i][k] + dp[k+1][j] (i <= k < j)
		for l := 2; l <= n; l++ {
			for i := 0; i <= n-l; i++ {
				j := i + l - 1

				if dp[i+1][j-1] == j-i-1 && abs(w[i]-w[j]) <= 1 {
					dp[i][j] = j - i + 1
					continue
				}

				for k := i; k < j; k++ {
					dp[i][j] = max(dp[i][j], dp[i][k]+dp[k+1][j])
				}
			}
		}

		results = append(results, dp[0][n-1])
	}

	for _, result := range results {
		fmt.Println(result)
	}
}
