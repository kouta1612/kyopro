package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(generateParenthesis(3))
	fmt.Println(generateParenthesis(1))
}

func generateParenthesis(n int) []string {
	result := []string{}

	for bit := 0; bit < 1<<(2*n); bit++ {
		kakko := []string{}
		for i := 0; i < 2*n; i++ {
			if (bit & (1 << i)) > 0 {
				kakko = append(kakko, "(")
			} else {
				kakko = append(kakko, ")")
			}
		}

		if valid(kakko) {
			result = append(result, strings.Join(kakko, ""))
		}
	}

	return result
}

func valid(kakko []string) bool {
	stack := []string{}
	for i := range kakko {
		if kakko[i] == ")" {
			if len(stack) == 0 {
				return false
			}
			if stack[len(stack)-1] == ")" {
				return false
			}

			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, kakko[i])
		}
	}

	return len(stack) == 0
}
