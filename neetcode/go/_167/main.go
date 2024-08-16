package main

import (
	"fmt"
)

func main() {
	fmt.Println(twoSum([]int{3, 24, 50, 79, 88, 150, 345}, 200))
}

func twoSum(numbers []int, target int) []int {
	left, right := 0, len(numbers)-1

	for left < right {
		sum := numbers[left] + numbers[right]
		if sum == target {
			return []int{left + 1, right + 1}
		}

		if sum < target {
			left++
		} else {
			right--
		}
	}

	return []int{}
}
