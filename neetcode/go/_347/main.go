package main

import (
	"fmt"
)

func main() {
	fmt.Println(topKFrequent([]int{1, 1, 1, 2, 2, 3}, 2))
}

func topKFrequent(nums []int, k int) []int {
	mp := make(map[int]int)

	for _, v := range nums {
		mp[v]++
	}

	frequent := make([][]int, len(nums)+1)
	for k, v := range mp {
		frequent[v] = append(frequent[v], k)
	}

	result := make([]int, 0, k)
	for i := len(nums); i >= 0; i-- {
		if len(frequent[i]) == 0 {
			continue
		}

		for _, v := range frequent[i] {
			result = append(result, v)
			if len(result) == k {
				return result
			}
		}
	}

	return []int{}
}
