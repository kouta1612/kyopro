package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	result := new(ListNode)
	// 一時変数にする理由はresultに先頭のポインタを格納しておいたまま更新していきたいから
	tmp := result

	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			tmp.Next = list1
			list1 = list1.Next
		} else {
			tmp.Next = list2
			list2 = list2.Next
		}
		tmp = tmp.Next
	}

	if list1 != nil {
		tmp.Next = list1
	}

	if list2 != nil {
		tmp.Next = list2
	}

	result = result.Next

	return result
}
