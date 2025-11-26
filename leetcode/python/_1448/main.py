from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(node: Optional[TreeNode], curMax: int) -> int:
            if not node: return 0
            res = 1 if node.val >= curMax else 0
            curMax = max(curMax, node.val)
            res += dfs(node.left, curMax) + dfs(node.right, curMax)
            return res
        return dfs(root, float('-inf'))

print(Solution().goodNodes(TreeNode(3, TreeNode(1, TreeNode(3)), TreeNode(4, TreeNode(1), TreeNode(5)))))