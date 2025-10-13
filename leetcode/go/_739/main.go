package main

import "fmt"

func main() {
	fmt.Println(dailyTemperatures([]int{73, 74, 75, 71, 69, 72, 76, 73}))
	fmt.Println(dailyTemperatures([]int{30, 40, 50, 60}))
	fmt.Println(dailyTemperatures([]int{30, 60, 90}))
}

type model struct {
	i, t int
}

func dailyTemperatures(temperatures []int) []int {
	result := make([]int, len(temperatures))
	stack := make([]model, 0)

	for i, v := range temperatures {
		for len(stack) > 0 && v > stack[len(stack)-1].t {
			topInd := stack[len(stack)-1].i
			result[topInd] = i - topInd
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, model{i: i, t: v})
	}

	return result
}
