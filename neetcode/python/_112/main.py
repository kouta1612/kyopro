from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def helper(root: Optional[TreeNode], targetSum, cursum: int) -> bool:
            if root and not root.left and not root.right:
                return targetSum == cursum
            left = helper(root.left, targetSum, cursum + root.left.val) if root.left else False
            right = helper(root.right, targetSum, cursum + root.right.val) if root.right else False
            return left or right
        if not root:
            return False
        return helper(root, targetSum, root.val)

print(Solution().hasPathSum(TreeNode(5, TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))), TreeNode(8, TreeNode(13), TreeNode(4, None, TreeNode(1)))), 22))