package main

import "fmt"

func main() {
	var n, x int
	fmt.Scan(&n, &x)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	l := 0
	r := n
	for r-l >= 1 {
		mid := (r + l) / 2
		if a[mid] == x {
			fmt.Println(mid + 1)
			return
		}
		if a[mid] > x {
			r = mid
		}
		if a[mid] < x {
			l = mid + 1
		}
	}
}
