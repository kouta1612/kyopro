from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        self.res = 0

        def dfs(node: Optional[TreeNode], curMax: int):
            if not node: return
            if node.val >= curMax:
                self.res += 1
                curMax = node.val
            dfs(node.left, curMax)
            dfs(node.right, curMax)
        
        dfs(root, -1<<30)
        return self.res

print(Solution().goodNodes(TreeNode(3, TreeNode(1, TreeNode(3)), TreeNode(4, TreeNode(1), TreeNode(5)))))