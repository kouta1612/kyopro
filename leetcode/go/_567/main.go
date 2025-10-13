package main

import "fmt"

func main() {
	fmt.Println(checkInclusion("ab", "eidbaooo"))
	fmt.Println(checkInclusion("ab", "eidboaoo"))
}

func checkInclusion(s1 string, s2 string) bool {
	count1 := make(map[byte]int)
	for i := range s1 {
		count1[s1[i]]++
	}

	count2 := make(map[byte]int)
	l := 0
	for r := 0; r < len(s2); r++ {
		count2[s2[r]]++
		if (r - l + 1) < len(s1) {
			continue
		}

		ok := true
		for k1, v1 := range count1 {
			exist := false
			for k2, v2 := range count2 {
				if k1 == k2 && v1 == v2 {
					exist = true
				}
			}
			if !exist {
				ok = false
			}
		}

		if ok {
			return true
		}

		count2[s2[l]]--
		l++
	}

	return false
}
