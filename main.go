package main

import "fmt"

func main() {
	a := map[int]int{-1: 1, 2: 100}
	b := a
	a[-1] = 100
	fmt.Printf("%p, %p\n", &a, &b)
}
