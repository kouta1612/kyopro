package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	a := make([]int, m)
	b := make([]bool, n)
	result := make([]int, n)

	for i := 0; i < m; i++ {
		fmt.Scan(&a[i])
		b[a[i]-1] = true
	}

	count := 0
	for i := n - 1; i >= 0; i-- {
		if !b[i] {
			count++
			result[i] = count
		} else {
			count = 0
		}
	}

	for i := 0; i < n; i++ {
		fmt.Println(result[i])
	}
}
