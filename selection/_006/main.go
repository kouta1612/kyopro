package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	ans := 0
	for i := 0; i <= 9; i++ {
		for j := 0; j <= 9; j++ {
			for k := 0; k <= 9; k++ {
				t := s
				x := strings.Index(t, strconv.Itoa(i))
				if x == -1 {
					continue
				}
				t = t[x+1:]

				y := strings.Index(t, strconv.Itoa(j))
				if y == -1 {
					continue
				}
				t = t[y+1:]

				z := strings.Index(t, strconv.Itoa(k))
				if z == -1 {
					continue
				}

				ans++
			}
		}
	}

	fmt.Println(ans)
}
