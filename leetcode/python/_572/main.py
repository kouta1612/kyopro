from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root and not subRoot: return True
        if not root: return False

        return self.isSameTree(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
    
    def isSameTree(self, node1: Optional[TreeNode], node2: Optional[TreeNode]) -> bool:
        if not node1 and not node2: return True
        if not node1 or not node2: return False
        if node1.val != node2.val: return False

        return self.isSameTree(node1.left, node2.left) and self.isSameTree(node1.right, node2.right)

print(Solution().isSubtree(TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(2)), TreeNode(5)), TreeNode(4, TreeNode(1), TreeNode(2))))
print(Solution().isSubtree(TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(2, TreeNode(0))), TreeNode(5)), TreeNode(4, TreeNode(1), TreeNode(2))))