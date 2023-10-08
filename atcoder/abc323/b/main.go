package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)

	s := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&s[i])
	}

	// i番目のプレイヤーの勝ち数
	p := make([]int, n)

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if s[i][j] == 'o' {
				p[i]++
			}
		}
	}

	// i番目のプレイヤーの番号
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		ans[i] = i
	}

	sort.Slice(ans, func(i, j int) bool {
		if p[ans[i]] == p[ans[j]] {
			return ans[i] < ans[j]
		}
		return p[ans[i]] > p[ans[j]]
	})

	for i := 0; i < n; i++ {
		fmt.Print(ans[i]+1, " ")
	}
	fmt.Println()
}
