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

	res := 0
	dfs(root, &res)
	return res
}

func dfs(root *TreeNode, res *int) int {
	if root == nil {
		return -1
	}
	left, right := dfs(root.Left, res), dfs(root.Right, res)
	*res = max(*res, left+right+2)
	return max(left, right) + 1
}
