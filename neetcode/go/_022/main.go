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
	stack := []string{}

	var dfs func(int, int)
	dfs = func(open, close int) {
		if open == n && close == n {
			result = append(result, strings.Join(stack, ""))
		}
		if open < n {
			stack = append(stack, "(")
			dfs(open+1, close)
			stack = stack[:len(stack)-1]
		}
		if close < open {
			stack = append(stack, ")")
			dfs(open, close+1)
			stack = stack[:len(stack)-1]
		}
	}
	dfs(0, 0)

	return result
}
