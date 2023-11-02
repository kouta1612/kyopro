package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	p := make([]int, n+1)
	for i := 1; i < n+1; i++ {
		fmt.Scan(&p[i])
	}

	s := make([]int, 0)
	for i := 0; i < n+1; i++ {
		for j := 0; j < n+1; j++ {
			s = append(s, p[i]+p[j])
		}
	}

	sort.Ints(s)

	result := 0
	for i := 0; i < len(s); i++ {
		it := upper_bound(s, m-s[i])
		if it >= 0 {
			result = int(math.Max(float64(result), float64(s[it]+s[i])))
		}
	}

	fmt.Println(result)
}

func upper_bound(a []int, v int) int {
	ok, ng := -1, len(a)

	for ng-ok > 1 {
		mid := (ok + ng) / 2
		if a[mid] <= v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}
