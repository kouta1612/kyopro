package main

import "fmt"

const INF = 1 << 60

func main() {
	a := []int{1, 4, 6, 3, 8}
	dp := lis(a)

	// aの単調増加部分文字列の長さを求める
	fmt.Println(dp, lowerBound(dp, INF)-1)
}

// 下記の定義に基づくLIS（単調増加部分列）を返す
// dp[i]: 長さがiの数列において最後の要素が最小のもの
func lis(a []int) []int {
	n := len(a)

	dp := make([]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = INF
	}
	dp[0] = -INF

	for i := 0; i < n; i++ {
		it := lowerBound(dp, a[i])
		dp[it] = a[i]
	}

	return dp
}

// a[i] >= v を満たす最小のインデックスを取得する
func lowerBound(a []int, v int) int {
	ng, ok := -1, len(a)
	for ok-ng > 1 {
		mid := (ok + ng) / 2
		if a[mid] >= v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}
