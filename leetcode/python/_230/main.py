from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.counter = 0
        self.res = -1
        
        def dfs(node: Optional[TreeNode]):
            if not node: return
            dfs(node.left)
            self.counter += 1
            if self.counter == k: 
                self.res = node.val
                return
            dfs(node.right)

        dfs(root)
        return self.res

print(Solution().kthSmallest(TreeNode(3, TreeNode(1, None, TreeNode(2)), TreeNode(4)), 1))