package main

import (
	"fmt"
)

func main() {
	fmt.Println(longestConsecutive([]int{100, 4, 200, 1, 3, 2}))
	fmt.Println(longestConsecutive([]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}))
}

func longestConsecutive(nums []int) int {
	set := make(map[int]bool)
	for _, v := range nums {
		set[v] = true
	}

	result := 0
	seen := make(map[int]bool)
	for _, v := range nums {
		if set[v-1] || seen[v] {
			continue
		}

		seen[v] = true

		len := 1
		for now := v + 1; set[now]; {
			now++
			len++
		}

		result = max(result, len)
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
