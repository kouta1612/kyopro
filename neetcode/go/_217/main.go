package main

import "fmt"

func main() {
	fmt.Println(containsDuplicate([]int{1, 2, 3, 3}))
}

func containsDuplicate(nums []int) bool {
	maps := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if maps[nums[i]] >= 1 {
			return true
		}
		maps[nums[i]]++
	}
	return false
}
