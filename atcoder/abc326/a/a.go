package main

import "fmt"

func main() {
	var x, y int
	fmt.Scan(&x, &y)

	if (x < y && y-x <= 2) || (x > y && x-y <= 3) {
		fmt.Println(("Yes"))
	} else {
		fmt.Println("No")
	}
}
