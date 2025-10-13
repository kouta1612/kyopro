package main

import "fmt"

func main() {
	fmt.Println(isBalanced(nil))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return dfs(root).balanced
}

type node struct {
	balanced bool
	height   int
}

func dfs(root *TreeNode) node {
	if root == nil {
		return node{true, 0}
	}

	left, right := dfs(root.Left), dfs(root.Right)
	balanced := left.balanced && right.balanced && abs(left.height-right.height) <= 1

	return node{balanced, max(left.height, right.height) + 1}
}

func abs(v int) int {
	if v < 0 {
		return -v
	}
	return v
}
