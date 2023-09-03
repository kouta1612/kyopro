package main

import "fmt"

func main() {
	var q int
	fmt.Scan(&q)

	queue := make([]string, 0)

	for i := 0; i < q; i++ {
		var query int
		fmt.Scan(&query)
		if query == 1 {
			var name string
			fmt.Scan(&name)

			queue = append(queue, name)
		}
		if query == 2 {
			fmt.Println(queue[0])
		}
		if query == 3 {
			queue = queue[1:]
		}
	}
}
