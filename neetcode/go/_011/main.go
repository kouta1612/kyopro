package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
}

func maxArea(height []int) int {
	l, r := 0, len(height)-1
	result := 0
	for l < r {
		w := r - l
		hmin := int(math.Min(float64(height[l]), float64(height[r])))
		hmax := int(math.Max(float64(height[l]), float64(height[r])))
		result = int(math.Max(float64(result), float64(w*hmin)))

		if height[l] == hmax {
			r--
		} else if height[r] == hmax {
			l++
		}
	}

	return result
}
