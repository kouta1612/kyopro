package main

import (
	"fmt"
	"sort"
	"strings"
)

func main() {
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	mp := make(map[string][]string)

	for _, str := range strs {
		s := strings.Split(str, "")
		sort.Strings(s)
		t := strings.Join(s, "")

		mp[t] = append(mp[t], str)
	}

	result := make([][]string, 0, len(mp))
	for _, vs := range mp {
		result = append(result, vs)
	}

	return result
}
