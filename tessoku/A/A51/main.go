package main

import "fmt"

func main() {
	var q int
	fmt.Scan(&q)

	var stack []string
	for i := 0; i < q; i++ {
		var query int
		fmt.Scan(&query)

		if query == 1 {
			var name string
			fmt.Scan(&name)

			stack = append(stack, name)
		}
		if query == 2 {
			fmt.Println(stack[len(stack)-1])
		}
		if query == 3 {
			stack = stack[:len(stack)-1]
		}
	}
}
