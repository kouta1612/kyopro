from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.res = True

        def dfs(root: Optional[TreeNode]) -> int:
            if not self.res: return 0
            if not root: return 0
            left, right = dfs(root.left), dfs(root.right)
            if abs(left - right) > 1:
                self.res = False
                return 0
            return max(left, right) + 1

        dfs(root)
        return self.res

print(Solution().isBalanced(None))