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

	result := 0
	for i := 0; i < 1<<n; i++ {
		a := make([]int, 0)
		for j := 0; j < n; j++ {
			if (i & (1 << j)) > 0 {
				a = append(a, j)
			}
		}

		ok := true
		for _, v := range a {
			for _, vv := range a {
				if v == vv {
					continue
				}

				if !g[edge{v, vv}] {
					ok = false
				}
			}
		}

		if ok {
			result = int(math.Max(float64(result), float64(len(a))))
		}
	}

	fmt.Println(result)
}
