package main

import "fmt"

func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("(]"))
	fmt.Println(isValid("([])"))
}

func isValid(s string) bool {
	pairs := map[byte]byte{
		')': '(',
		'}': '{',
		']': '[',
	}

	stack := make([]byte, 0)
	for i := range s {
		open, exist := pairs[s[i]]
		if !exist {
			stack = append(stack, s[i])
			continue
		}
		if len(stack) == 0 {
			return false
		}
		if stack[len(stack)-1] != open {
			return false
		}

		stack = stack[:len(stack)-1]
	}

	return len(stack) == 0
}
