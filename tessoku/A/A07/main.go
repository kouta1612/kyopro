package main

import (
	"fmt"
)

func main() {
	var d, n int
	fmt.Scan(&d, &n)

	sum := make([]int, d+1)
	for i := 0; i < n; i++ {
		var l, r int
		fmt.Scan(&l, &r)

		sum[l-1] += 1
		sum[r] -= 1
	}

	for i := 1; i < d+1; i++ {
		sum[i] += sum[i-1]
	}
	for i := 0; i < d; i++ {
		fmt.Println(sum[i])
	}
}
