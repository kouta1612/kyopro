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

	left, right := dfs(root.Left), dfs(root.Right)
	if abs(left-right) > 1 {
		return false
	}

	return isBalanced(root.Left) && isBalanced(root.Right)
}

func dfs(root *TreeNode) int {
	if root == nil {
		return -1
	}
	return 1 + max(dfs(root.Left), dfs(root.Right))
}

func abs(v int) int {
	if v < 0 {
		return -v
	}
	return v
}
