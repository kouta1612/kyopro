package main

import (
	"fmt"
	"sort"
	"strings"
)

func main() {
	fmt.Println(isAnagram("anagram", "nagaram"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	sa, ta := strings.Split(s, ""), strings.Split(t, "")
	sort.Strings(sa)
	sort.Strings(ta)

	for i := 0; i < len(sa); i++ {
		if sa[i] != ta[i] {
			return false
		}
	}

	return true
}
