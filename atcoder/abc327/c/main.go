package main

import "fmt"

func main() {
	a := make([][]int, 9)
	for i := 0; i < 9; i++ {
		a[i] = make([]int, 9)
		for j := 0; j < 9; j++ {
			fmt.Scan(&a[i][j])
			a[i][j]--
		}

	}

	ok := true
	for i := 0; i < 9; i++ {
		found := make([]bool, 9)
		for j := 0; j < 9; j++ {
			if found[a[i][j]] {
				ok = false
			}
			found[a[i][j]] = true
		}
	}
	for i := 0; i < 9; i++ {
		found := make([]bool, 9)
		for j := 0; j < 9; j++ {
			if found[a[j][i]] {
				ok = false
			}
			found[a[j][i]] = true
		}
	}
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			found := make([]bool, 9)
			for x := 0; x < 3; x++ {
				for y := 0; y < 3; y++ {
					if found[a[i*3+x][j*3+y]] {
						ok = false
					}
					found[a[i*3+x][j*3+y]] = true
				}
			}
		}
	}

	if ok {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
