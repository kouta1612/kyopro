package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
	fmt.Println(threeSum([]int{-4, -1, -1, 0, 1, 2}))
}

func threeSum(nums []int) [][]int {
	sort.Ints(nums)

	result := make([][]int, 0)
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i-1] == nums[i] {
			continue
		}

		l, r := i+1, len(nums)-1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			if sum > 0 {
				r--
			} else if sum < 0 {
				l++
			} else {
				result = append(result, []int{nums[i], nums[l], nums[r]})
				l++
				for nums[l-1] == nums[l] && l < r {
					l++
				}
			}
		}
	}

	return result
}
