package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	var d, n, m int
	fmt.Scan(&d, &n, &m)

	s := make([]int, n+1)
	for i := 1; i < n; i++ {
		fmt.Scan(&s[i])
	}
	s[n] = d

	t := make([]int, m)
	for i := 0; i < m; i++ {
		fmt.Scan(&t[i])
	}

	sort.Ints(s)

	result := 0
	for i := 0; i < m; i++ {
		it := lower_bound(s, t[i])
		tmp := math.Abs(float64(s[it] - t[i]))
		if it > 0 {
			tmp = math.Min(tmp, math.Abs(float64(s[it-1]-t[i])))
		}
		result += int(tmp)
	}

	fmt.Println(result)
}

func lower_bound(a []int, t int) int {
	ng, ok := -1, len(a)

	for ok-ng > 1 {
		mid := (ok + ng) / 2

		if a[mid] >= t {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}
