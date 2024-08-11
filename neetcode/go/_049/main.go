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
	result := make([][]string, 0)
	mp := make(map[string][]string)

	for _, str := range strs {
		s := strings.Split(str, "")
		sort.Strings(s)
		t := strings.Join(s, "")

		if _, ok := mp[t]; !ok {
			mp[t] = []string{str}
			continue
		}

		mp[t] = append(mp[t], str)
	}

	for _, vs := range mp {
		result = append(result, []string{})
		for _, v := range vs {
			i := len(result) - 1
			result[i] = append(result[i], v)
		}
	}

	return result
}
