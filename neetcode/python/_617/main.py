from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root1 and not root2: return None
        if not root1: return root2
        if not root2: return root1

        res = TreeNode(root1.val + root2.val)
        left = self.mergeTrees(root1.left, root2.left)
        right = self.mergeTrees(root1.right, root2.right)
        res.left, res.right = left, right

        return res

print(Solution().mergeTrees(TreeNode(1, TreeNode(3, TreeNode(5)), TreeNode(2)), TreeNode(2, TreeNode(1, None, TreeNode(4)), TreeNode(3, None, TreeNode(7)))))