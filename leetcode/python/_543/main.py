from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        def dfs(root: Optional[TreeNode]) -> int:
            if not root: return 0
            left, right = dfs(root.left), dfs(root.right)
            self.res = max(self.res, left + right)
            return max(left, right) + 1

        dfs(root)
        return self.res

print(Solution().diameterOfBinaryTree(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))))