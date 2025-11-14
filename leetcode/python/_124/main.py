from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.res = float('-inf')

        def dfs(node: Optional[TreeNode]) -> int:
            if not node: return 0
            cur = node.val
            left, right = dfs(node.left), dfs(node.right)
            self.res = max(self.res, cur + max(0, left) + max(0, right))
            return cur + max(0, left, right)
        dfs(root)
        return self.res

print(Solution().maxPathSum(TreeNode(1, TreeNode(2), TreeNode(3))))
print(Solution().maxPathSum(TreeNode(-10, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
print(Solution().maxPathSum(TreeNode(-3)))
print(Solution().maxPathSum(TreeNode(1, TreeNode(-2, TreeNode(1, TreeNode(-1)), TreeNode(-2)), TreeNode(-3, TreeNode(-2)))))
print(Solution().maxPathSum(TreeNode(1, TreeNode(-2, TreeNode(1, TreeNode(-1)), TreeNode(-2)), TreeNode(-3, TreeNode(-2)))))