package main

import "fmt"

func main() {
	fmt.Println(diameterOfBinaryTree(nil))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left, right := dfs(root.Left), dfs(root.Right)
	res := left + right + 2
	sub := max(diameterOfBinaryTree(root.Left), diameterOfBinaryTree(root.Right))
	return max(res, sub)
}

func dfs(root *TreeNode) int {
	if root == nil {
		return -1
	}
	return max(dfs(root.Left), dfs(root.Right)) + 1
}
