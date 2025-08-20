package main

import "fmt"

func main() {
	fmt.Println(isSubtree(nil, nil))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if root == nil && subRoot == nil {
		return true
	}
	if root == nil || subRoot == nil {
		return false
	}
	if issame(root, subRoot) {
		return true
	}
	return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}

func issame(root, subRoot *TreeNode) bool {
	if root == nil && subRoot == nil {
		return true
	}
	if root != nil && subRoot != nil && root.Val == subRoot.Val {
		return issame(root.Left, subRoot.Left) && issame(root.Right, subRoot.Right)
	}
	return false
}
