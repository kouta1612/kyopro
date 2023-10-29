package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	sort.Ints(a)

	var r, result int
	for l := 0; l < n; l++ {
		for r < n && a[r] < a[l]+m {
			r++
		}
		result = int(math.Max(float64(result), float64(r-l)))
	}

	fmt.Println(result)
}
