package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	result := strings.Index(s, "ABC")
	if result == -1 {
		fmt.Println(-1)
	} else {
		fmt.Println(result + 1)
	}
}
