package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)

	h, s := make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&h[i], &s[i])
	}

	ng, ok := -1, 1<<60
	for ok-ng > 1 {
		mid := (ng + ok) / 2
		if isOK(h, s, len(h), mid) {
			ok = mid
		} else {
			ng = mid
		}
	}

	fmt.Println(ok)
}

func isOK(h, s []int, n, border int) bool {
	seconds := make([]int, n)

	for i := 0; i < n; i++ {
		if border < h[i] {
			return false
		}

		seconds[i] = (border - h[i]) / s[i]
	}

	sort.Ints(seconds)

	for i := 0; i < n; i++ {
		if seconds[i] < i {
			return false
		}
	}

	return true
}
