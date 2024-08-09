package main

import "fmt"

func main() {
	fmt.Println(containsDuplicate([]int{1, 2, 3, 3}))
}

func containsDuplicate(nums []int) bool {
	mp := make(map[int]bool)
	for _, num := range nums {
		if _, exist := mp[num]; exist {
			return true
		}
		mp[num] = true
	}
	return false
}
