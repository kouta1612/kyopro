package main

import "fmt"

func main() {
	var s string
	fmt.Scan(&s)

	ok := true
	for i := 0; i < 16; i++ {
		if i%2 == 1 {
			if s[i] == '1' {
				ok = false
			}
		}
	}

	if ok {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
