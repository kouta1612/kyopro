package main

import (
	"fmt"
	"math"
)

func main() {
	var p float64
	fmt.Scan(&p)

	l, r := 0.0, 1e18
	for i := 0; i < 1000; i++ {
		ml, mr := (2*l+r)/3, (l+2*r)/3
		if f(ml, p) <= f(mr, p) {
			r = mr
		} else {
			l = ml
		}
	}

	fmt.Println(f(l, p))
}

func f(x, p float64) float64 {
	return x + p/(math.Pow(2, x/1.5))
}
