package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)

	var s, c int64
	p := make(map[int64]int64)
	k := make([]int64, 0)
	for i := 0; i < n; i++ {
		fmt.Scan(&s, &c)
		p[s] = c
		k = append(k, s)
	}

	sort.Slice(k, func(i, j int) bool {
		return k[i] < k[j]
	})

	var ans int64
	for i := 0; len(k) > 0; i++ {
		size := k[0]
		count := p[size]

		ans += count % 2
		delete(p, size)
		k = k[1:]

		size *= 2
		count /= 2

		if count > 0 {
			p[size] += count
			k = append(k, size)
		}
	}

	fmt.Println(ans)
}
