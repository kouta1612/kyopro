package main

import "fmt"

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))
}

func maxProfit(prices []int) int {
	l, r := 0, 1

	result := 0
	for r < len(prices) {
		if prices[l] < prices[r] {
			result = max(result, prices[r]-prices[l])
		} else {
			l = r
		}

		r++
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
