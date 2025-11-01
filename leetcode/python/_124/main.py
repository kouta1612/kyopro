from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    maxSum = -1<<32
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def dfs(root: Optional[TreeNode]) -> int:
            if not root: return 0
            res = root.val
            left, right = dfs(root.left), dfs(root.right)
            self.maxSum = max(self.maxSum, res + max(left, 0) + max(right, 0))
            return res + max(0, left, right)
        dfs(root)
        return self.maxSum

print(Solution().maxPathSum(TreeNode(1, TreeNode(2), TreeNode(3))))
print(Solution().maxPathSum(TreeNode(-10, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
print(Solution().maxPathSum(TreeNode(-3)))
print(Solution().maxPathSum(TreeNode(1, TreeNode(-2, TreeNode(1, TreeNode(-1)), TreeNode(-2)), TreeNode(-3, TreeNode(-2)))))
print(Solution().maxPathSum(TreeNode(1, TreeNode(-2, TreeNode(1, TreeNode(-1)), TreeNode(-2)), TreeNode(-3, TreeNode(-2)))))