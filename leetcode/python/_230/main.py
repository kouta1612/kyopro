from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.counter, self.res = 0, 0
        def helper(node: Optional[TreeNode]):
            if not node: return
            if self.res: return
            helper(node.left)
            self.counter += 1
            if self.counter == k:
                self.res = node.val
                return
            helper(node.right)
        helper(root)
        return self.res

print(Solution().kthSmallest(TreeNode(3, TreeNode(1, None, TreeNode(2)), TreeNode(4)), 1))