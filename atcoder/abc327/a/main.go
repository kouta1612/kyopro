package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	var s string
	fmt.Scan(&n, &s)

	if strings.Contains(s, "ab") || strings.Contains(s, "ba") {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
