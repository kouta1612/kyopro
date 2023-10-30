package main

import (
	"fmt"
	"math"
)

type edge struct {
	x, y int
}

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	x := make([]int, m)
	y := make([]int, m)
	g := make(map[edge]bool)
	for i := 0; i < m; i++ {
		fmt.Scan(&x[i], &y[i])
		g[edge{x: x[i] - 1, y: y[i] - 1}] = true
		g[edge{x: y[i] - 1, y: x[i] - 1}] = true
	}

	result := dfs(0, n, []int{}, g)

	fmt.Println(result)
}

func dfs(p, n int, a []int, g map[edge]bool) int {
	if p == n {
		ok := true
		for i := 0; i < len(a); i++ {
			for j := 0; j < len(a); j++ {
				if i == j {
					continue
				}

				if !g[edge{x: a[i], y: a[j]}] {
					ok = false
				}
			}
		}

		if ok {
			return len(a)
		}

		return 0
	}

	c := make([]int, len(a))
	copy(c, a)
	c = append(c, p)

	s := dfs(p+1, n, a, g)
	t := dfs(p+1, n, c, g)

	return int(math.Max(float64(s), float64(t)))
}
