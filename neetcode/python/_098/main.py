from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node: Optional[TreeNode], left, right: int) -> bool:
            if not node: return True
            if not (left < node.val < right): return False

            lt = helper(node.left, left, node.val)
            rt = helper(node.right, node.val, right)
            return lt and rt
        return helper(root, -1<<32, 1<<32)

print(Solution().isValidBST(None))