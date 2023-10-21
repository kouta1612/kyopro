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
				key := -1
				for a := 0; a < n; a++ {
					if strconv.Itoa(i) == string(s[a]) {
						key = a
						break
					}
				}
				if key == -1 {
					continue
				}

				key2 := -1
				for b := key + 1; b < n; b++ {
					if strconv.Itoa(j) == string(s[b]) {
						key2 = b
						break
					}
				}

				if key2 == -1 {
					continue
				}

				key3 := -1
				for c := key2 + 1; c < n; c++ {
					if strconv.Itoa(k) == string(s[c]) {
						key3 = c
						break
					}
				}
				if key3 == -1 {
					continue
				}

				ans++
			}
		}
	}

	fmt.Println(ans)
}
