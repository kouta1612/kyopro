package main

import "fmt"

func main() {
	fmt.Println(isAnagram("anagram", "nagaram"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	smaps := map[rune]int{}
	tmaps := map[rune]int{}
	for _, ss := range s {
		smaps[ss]++
	}
	for _, tt := range t {
		tmaps[tt]++
	}
	for k, v := range smaps {
		if tmaps[k] != v {
			return false
		}
	}
	return true
}
