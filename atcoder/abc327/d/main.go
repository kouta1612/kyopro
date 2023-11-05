package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	a, b := make([]int, m), make([]int, m)
	for i := 0; i < m; i++ {
		fmt.Scan(&a[i])
	}
	for i := 0; i < m; i++ {
		fmt.Scan(&b[i])
	}
	for i := 0; i < m; i++ {
		a[i]--
		b[i]--
	}

	bit := make([]int, n)
	for i := 0; i < n; i++ {
		bit[i] = -1
	}

	result := true
	for i := 0; i < m; i++ {
		if a[i] == b[i] {
			result = false
			break
		}
		if bit[a[i]] == -1 && bit[b[i]] == -1 {
			bit[a[i]] = 0
			bit[b[i]] = 1
			continue
		}
		if bit[a[i]] == -1 && bit[b[i]] != -1 {
			bit[a[i]] = 1 - bit[b[i]]
			continue
		}
		if bit[a[i]] != -1 && bit[b[i]] == -1 {
			bit[b[i]] = 1 - bit[a[i]]
			continue
		}
		if bit[a[i]] != -1 && bit[b[i]] != -1 {
			if bit[a[i]] == bit[b[i]] {
				result = false
				break
			}
		}
	}

	if result {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
