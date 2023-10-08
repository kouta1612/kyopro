package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	a := make([]int, m)
	for i := 0; i < m; i++ {
		fmt.Scan(&a[i])
	}

	s := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&s[i])
	}

	p := make([]int, n)
	for i := 0; i < n; i++ {
		p[i] += i + 1
		for j := 0; j < m; j++ {
			if s[i][j] == 'o' {
				p[i] += a[j]
			}
		}
	}

	max := 0
	for i := 0; i < n; i++ {
		max = int(math.Max(float64(max), float64(p[i])))
	}

	for i := 0; i < n; i++ {
		ans := 0

		r := make([]int, 0)
		for j := 0; j < m; j++ {
			if s[i][j] == 'x' {
				r = append(r, a[j])
			}
		}
		sort.Slice(r, func(i, j int) bool {
			return r[i] > r[j]
		})

		for j := 0; max > p[i]; j++ {
			p[i] += r[j]
			ans++
		}

		fmt.Println(ans)
	}
}
