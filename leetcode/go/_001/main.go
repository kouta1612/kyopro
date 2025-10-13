package main

import (
	"fmt"
)

func main() {
	fmt.Println(twoSum([]int{3, 2, 4}, 6))
}

func twoSum(nums []int, target int) []int {
	mp := make(map[int]int)
	for i, v := range nums {
		mp[v] = i
	}

	for i, num := range nums {
		t := target - num
		if v, ok := mp[t]; ok && v != i {
			return []int{i, v}
		}
	}

	return []int{}
}
