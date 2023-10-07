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

	dp := map[[5]int]int{{0, 0, 0, 0, 0}: 0}
	for i := 0; i < n; i++ {
		tmp := copyMap(dp)
		for now := range tmp {
			next := now
			for j := 0; j < k; j++ {
				next[j] = int(math.Min(float64(p), float64(now[j]+a[i][j])))
			}
			if cost, exist := dp[next]; exist {
				dp[next] = int(math.Min(float64(cost), float64(tmp[now]+c[i])))
			} else {
				dp[next] = tmp[now] + c[i]
			}
		}
	}

	// ここはより良い方法ないか探る
	search := [5]int{p, p, p, p, p}
	for i := k; i < 5; i++ {
		search[i] = 0
	}

	if dp[search] == 0 {
		fmt.Println(-1)
	} else {
		fmt.Println(dp[search])
	}
}

func copyMap(input map[[5]int]int) map[[5]int]int {
	result := make(map[[5]int]int)
	for i, v := range input {
		result[i] = v
	}
	return result
}
