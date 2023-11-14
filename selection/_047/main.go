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

func main() {
	sc.Split(bufio.ScanWords)

	n := scanInt()
	a := make([]int, 2*n)
	for i := 0; i < n; i++ {
		t := scanInt()
		a[i], a[i+n] = t, t
	}

	dp := make([][]int, 2*n)
	for i := 0; i < 2*n; i++ {
		dp[i] = make([]int, 2*n)
	}
	for i := 0; i < 2*n; i++ {
		if n%2 == 1 {
			dp[i][i] = a[i]
		}
	}

	// dp[i][j]: [i,j]のケーキからJOIがとるピースの最大
	// dp[i+1][j] + a[i] → dp[i][j]
	// dp[i][j-1] + a[j] → dp[i][j]
	for l := 2; l <= n; l++ {
		for i := 0; i <= 2*n-l; i++ {
			j := i + l - 1

			if (n-l)%2 == 0 {
				dp[i][j] = max(dp[i+1][j]+a[i], dp[i][j-1]+a[j])
			} else {
				if a[i] > a[j] {
					dp[i][j] = dp[i+1][j]
				} else {
					dp[i][j] = dp[i][j-1]
				}
			}
		}
	}

	result := 0
	for i := 0; i < n; i++ {
		result = max(result, dp[i][i+n-1])
	}

	fmt.Println(result)
}
