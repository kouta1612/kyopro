package main

import "fmt"

func main() {
	fmt.Println(hasCycle(nil))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	mp := make(map[*ListNode]struct{})
	for head != nil && head.Next != nil {
		if _, exist := mp[head.Next]; exist {
			return true
		}
		mp[head.Next] = struct{}{}
		head = head.Next
	}
	return false
}
