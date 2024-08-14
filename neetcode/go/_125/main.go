package main

import (
	"fmt"
	"unicode"
)

func main() {
	fmt.Println(isPalindrome("ababa"))
}

func isPalindrome(s string) bool {
	i, j := 0, len(s)-1
	arr := []rune(s)

	for i < j {
		left := unicode.ToLower(arr[i])
		right := unicode.ToLower(arr[j])

		if !(unicode.IsLetter(left) || unicode.IsDigit(left)) {
			i++
			continue
		}
		if !(unicode.IsLetter(right) || unicode.IsDigit(right)) {
			j--
			continue
		}

		if left != right {
			return false
		}

		i++
		j--
	}

	return true
}
