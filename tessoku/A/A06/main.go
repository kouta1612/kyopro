package main

import (
	"fmt"
)

func main() {
	var n, q int
	fmt.Scan(&n, &q)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	sum := make([]int, n+1)
	for i := 1; i < n+1; i++ {
		sum[i] += sum[i-1] + a[i-1]
	}

	for i := 0; i < q; i++ {
		var l, r int
		fmt.Scan(&l, &r)

		fmt.Println(sum[r] - sum[l-1])
	}
}
