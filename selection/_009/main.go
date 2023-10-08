package main

import (
	"fmt"
	"strconv"
)

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	ans := 0
	for i := 0; i <= 9; i++ {
		for j := 0; j <= 9; j++ {
			for k := 0; k <= 9; k++ {
				a := search(0, n, i, s)
				if a == -1 {
					continue
				}
				b := search(a+1, n, j, s)
				if b == -1 {
					continue
				}
				c := search(b+1, n, k, s)
				if c == -1 {
					continue
				}

				ans++
			}
		}
	}

	fmt.Println(ans)
}

func search(a, b, v int, s string) int {
	for i := a; i < b; i++ {
		if strconv.Itoa(v) == string(s[i]) {
			return i
		}
	}
	return -1
}
