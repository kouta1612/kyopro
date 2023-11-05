package main

import (
	"fmt"
)

func main() {
	var b int
	fmt.Scan(&b)

	for i := 1; i <= 16; i++ {
		a := 1
		for j := 0; j < i; j++ {
			a *= i
		}
		if a == b {
			fmt.Println(i)
			return
		}
	}

	fmt.Println(-1)
}
