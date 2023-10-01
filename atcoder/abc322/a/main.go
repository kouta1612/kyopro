package main

import "fmt"

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	for i := 0; i <= n-3; i++ {
		sub := s[i : i+3]
		if sub == "ABC" {
			fmt.Println(i + 1)
			return
		}
	}

	fmt.Println((-1))
}
