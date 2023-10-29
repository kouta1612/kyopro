package main

import (
	"fmt"
	"math"
)

func main() {
	var n int
	fmt.Scan(&n)

	m := make([][]bool, 5001)
	for i := 0; i <= 5000; i++ {
		m[i] = make([]bool, 5001)
	}

	x := make([]int, n)
	y := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&x[i], &y[i])
		m[x[i]][y[i]] = true
	}

	result := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			// 反時計に90°回転
			nx := -y[j] + y[i] + x[i]
			ny := x[j] - x[i] + y[i]
			if nx < 0 || nx > 5000 || ny < 0 || ny > 5000 {
				continue
			}
			if !m[nx][ny] {
				continue
			}

			nx2 := x[j] - y[j] + y[i]
			ny2 := y[j] + x[j] - x[i]
			if nx2 < 0 || nx2 > 5000 || ny2 < 0 || ny2 > 5000 {
				continue
			}
			if !m[nx2][ny2] {
				continue
			}

			result = int(math.Max(float64(result), math.Pow(float64(x[i]-x[j]), 2)+math.Pow(float64(y[i]-y[j]), 2)))
		}
	}

	fmt.Println(result)
}
