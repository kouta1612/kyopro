package main

import "fmt"

func main() {
	fmt.Println(minEatingSpeed([]int{3, 6, 7, 11}, 8))
	fmt.Println(minEatingSpeed([]int{30, 11, 23, 4, 20}, 5))
	fmt.Println(minEatingSpeed([]int{30, 11, 23, 4, 20}, 6))
	fmt.Println(minEatingSpeed([]int{2, 2}, 2))
}

func minEatingSpeed(piles []int, h int) int {
	ng, ok := -1, 1000000001
	for ng != ok-1 {
		mid := (ng + ok) / 2
		if mid == 0 || gettime(piles, mid) > h {
			ng = mid
		} else {
			ok = mid
		}
	}
	return ok
}

func gettime(piles []int, num int) int {
	result := 0
	for _, v := range piles {
		result += ceil(v, num)
	}
	return result
}

func ceil(a, b int) int {
	return (a + b - 1) / b
}
