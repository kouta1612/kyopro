package main

import "fmt"

func main() {
	fmt.Println(characterReplacement("ABAB", 2))
	fmt.Println(characterReplacement("AABABBA", 1))
}

func characterReplacement(s string, k int) int {
	count := make(map[byte]int)

	result := 0

	l := 0
	for r := range s {
		count[s[r]]++

		maxf := 0
		for _, v := range count {
			maxf = max(maxf, v)
		}

		if r-l+1-maxf <= k {
			result = max(result, r-l+1)
			continue
		}

		for r-l+1-maxf > k {
			count[s[l]]--
			l++
		}
	}

	return result
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
