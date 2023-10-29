package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)

	for {
		if is326(n) {
			fmt.Println(n)
			return
		}
		n++
	}
}

func is326(n int) bool {
	a := n / 100 * (n / 10 % 10)
	b := n % 10

	return a == b
}
