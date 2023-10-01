package main

import "fmt"

func main() {
	var n, m int
	var s, t string
	fmt.Scan(&n, &m, &s, &t)

	prefix := string(t[0:n])
	suffix := string(t[m-n:])
	if s == prefix && s == suffix {
		fmt.Println(0)
	} else if s == prefix && s != suffix {
		fmt.Println(1)
	} else if s != prefix && s == suffix {
		fmt.Println(2)
	} else {
		fmt.Println(3)
	}
}
