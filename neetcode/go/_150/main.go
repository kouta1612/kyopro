package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(evalRPN([]string{"2", "1", "+", "3", "*"}))
	fmt.Println(evalRPN([]string{"4", "13", "5", "/", "+"}))
	fmt.Println(evalRPN([]string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}))
}

func evalRPN(tokens []string) int {
	stack := []int{}

	for _, v := range tokens {
		if isSymbol(v) {
			num1 := stack[len(stack)-1]
			num2 := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, calc(num2, num1, v))
		} else {
			i, _ := strconv.Atoi(v)
			stack = append(stack, i)
		}
	}

	res := stack[len(stack)-1]
	return res
}

func isSymbol(v string) bool {
	mp := map[string]bool{
		"+": true,
		"-": true,
		"*": true,
		"/": true,
	}

	return mp[v]
}

func calc(a, b int, symbol string) int {
	switch symbol {
	case "+":
		return a + b
	case "-":
		return a - b
	case "*":
		return a * b
	case "/":
		return a / b
	}
	return 0
}
