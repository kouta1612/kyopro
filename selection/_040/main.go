package main

import "fmt"

const mod = 10000

func main() {
	var n, k int
	fmt.Scan(&n, &k)

	a, b := make([]int, k), make([]int, k)
	for i := 0; i < k; i++ {
		fmt.Scan(&a[i], &b[i])
		a[i]--
		b[i]--
	}

	m := make(map[int]int)
	for i := 0; i < len(a); i++ {
		m[a[i]] = b[i]
	}

	dp := make([][][]int, n+1)
	for i := 0; i < n+1; i++ {
		m := make([][]int, 3)
		for x := 0; x < 3; x++ {
			m[x] = make([]int, 3)
		}
		dp[i] = m
	}

	dp[0][0][0] = 1
	for i := 0; i < n; i++ {
		for x := 0; x < 3; x++ {
			for y := 0; y < 3; y++ {
				for z := 0; z < 3; z++ {
					if v, ok := m[i]; ok && v != z {
						continue
					}
					if i >= 2 && x == y && y == z {
						continue
					}

					dp[i+1][y][z] = (dp[i+1][y][z] + dp[i][x][y]) % mod
				}
			}
		}
	}

	result := 0
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			result = (result + dp[n][i][j]) % mod
		}
	}

	fmt.Println(result)
}
