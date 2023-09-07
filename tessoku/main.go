package main

import "fmt"

func main() {
	a := []int{1, 2, 3, 4, 5}
	permutation(a)
}

func permutation(a []int) {
	used := make([]bool, len(a))
	b := make([]int, len(a))
	copy(b, a)
	permutation2([]int{}, used, b)
}

func permutation2(perm []int, used []bool, seed []int) {
	if len(perm) == len(seed) {
		fmt.Println(perm)
		return
	}

	for i := 0; i < len(seed); i++ {
		if used[i] {
			continue
		}
		used[i] = true
		perm = append(perm, seed[i])
		permutation2(perm, used, seed)
		used[i] = false
		perm = perm[:len(perm)-1]
	}
}
