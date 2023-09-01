package main

import "fmt"

func main() {
	var q int
	fmt.Scan(&q)

	primes := make([]bool, 300001)
	for i := 2; i <= 300000; i++ {
		primes[i] = true
	}

	for i := 2; i*i <= 300000; i++ {
		for j := 2; i*j <= 300000; j++ {
			primes[i*j] = false
		}
	}

	for i := 0; i < q; i++ {
		var x int
		fmt.Scan(&x)

		if primes[x] {
			fmt.Println("Yes")
		} else {
			fmt.Println("No")
		}
	}
}
