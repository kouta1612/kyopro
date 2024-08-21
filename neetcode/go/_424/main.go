package main

import "fmt"

func main() {
	fmt.Println(characterReplacement("ABAB", 2))
	fmt.Println(characterReplacement("AABABBA", 1))
}

func characterReplacement(s string, k int) int {
	count := make(map[byte]int)

	result, maxf := 0, 0

	l := 0
	for r := range s {
		count[s[r]]++
		maxf = max(maxf, count[s[r]])

		for r-l+1-maxf > k {
			count[s[l]]--
			l++
		}

		result = max(result, r-l+1)
	}

	return result
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
