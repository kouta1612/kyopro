package main

import (
	"fmt"
	"math"
)

func main() {
	var n int
	fmt.Scan(&n)

	w := make([]int, n)
	x := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&w[i], &x[i])
	}

	result := 0
	for i := 0; i <= 24; i++ {
		sum := 0
		for j := 0; j < n; j++ {
			time := x[j] + i
			if time > 24 {
				time -= 24
			}
			if 9 <= time && time <= 17 {
				sum += w[j]
			}
		}
		result = int(math.Max(float64(result), float64(sum)))
	}

	fmt.Println(result)
}
