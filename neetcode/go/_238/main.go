package main

import "fmt"

func main() {
	fmt.Println(productExceptSelf([]int{1, 2, 3}))
}

func productExceptSelf(nums []int) []int {
	prefixes := make([]int, len(nums))
	prefixes[0] = 1
	for i := 1; i < len(nums); i++ {
		prefixes[i] = prefixes[i-1] * nums[i-1]
	}

	suffixes := make([]int, len(nums))
	suffixes[len(nums)-1] = 1
	for i := len(nums) - 2; i >= 0; i-- {
		suffixes[i] = suffixes[i+1] * nums[i+1]
	}

	result := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		result[i] = prefixes[i] * suffixes[i]
	}

	return result
}
