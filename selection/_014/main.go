package main

import (
	"fmt"
	"math"
)

func main() {
	var n, k int
	fmt.Scan(&n, &k)

	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	result := 1 << 40
	for i := 0; i < 1<<n; i++ {
		sum, pre := 0, 0
		b := make([]int, len(a))
		copy(b, a)
		for j := 1; j < n; j++ {
			if i&(1<<j) > 0 {
				if b[pre] >= b[j] {
					sum += b[pre] - b[j] + 1
					b[j] = b[pre] + 1
					pre = j
				}
			}
			if b[j] > b[pre] {
				pre = j
			}
		}

		count, now := 0, 0
		for j := 0; j < n; j++ {
			if now < b[j] {
				count++
				now = b[j]
			}
		}

		if count >= k {
			result = int(math.Min(float64(result), float64(sum)))
		}
	}

	fmt.Println(result)
}
