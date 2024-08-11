package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(topKFrequent([]int{1, 1, 1, 2, 2, 3}, 2))
}

type frequent struct {
	val, cnt int
}

func topKFrequent(nums []int, k int) []int {
	mp := make(map[int]int)

	for _, v := range nums {
		mp[v]++
	}

	fs := make([]frequent, 0, len(mp))
	for k, v := range mp {
		fs = append(fs, frequent{val: k, cnt: v})
	}

	sort.Slice(fs, func(i, j int) bool {
		return fs[i].cnt > fs[j].cnt
	})

	result := make([]int, 0, k)
	for i := 0; i < k; i++ {
		result = append(result, fs[i].val)
	}

	return result
}
