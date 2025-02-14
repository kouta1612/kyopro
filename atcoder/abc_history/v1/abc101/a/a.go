package main

import "fmt"

func main() {
	var s string
	fmt.Scan(&s)

	result := 0
	for i := 0; i < len(s); i++ {
		if s[i] == '+' {
			result++
		} else {
			result--
		}
	}

	fmt.Println(result)
}
