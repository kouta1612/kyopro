package main

import "fmt"

func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("(]"))
	fmt.Println(isValid("([])"))
}

func isValid(s string) bool {
	stack := make([]byte, 0)
	for i := range s {
		if s[i] == '(' || s[i] == '{' || s[i] == '[' {
			stack = append(stack, s[i])
			continue
		}

		if (s[i] == ')' && len(stack) > 0 && stack[len(stack)-1] == '(') || (s[i] == ']' && len(stack) > 0 && stack[len(stack)-1] == '[') || (s[i] == '}' && len(stack) > 0 && stack[len(stack)-1] == '{') {
			stack = stack[:len(stack)-1]
		} else {
			return false
		}
	}

	return len(stack) == 0
}
