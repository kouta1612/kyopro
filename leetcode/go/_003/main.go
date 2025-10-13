package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
	fmt.Println(lengthOfLongestSubstring("bbb"))
	fmt.Println(lengthOfLongestSubstring("pwwkew"))
}

func lengthOfLongestSubstring(s string) int {
	result := 0
	mp := make(map[byte]bool)

	l, r := 0, 0
	for r < len(s) {
		if !mp[s[r]] {
			mp[s[r]] = true
			result = max(result, r-l+1)
			r++
		} else {
			delete(mp, s[l])
			l++
		}
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
