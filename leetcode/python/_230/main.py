from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        n = 0
        stack = []
        cur = root
        while True:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            n += 1
            if n == k: return cur.val
            cur = cur.right

print(Solution().kthSmallest(TreeNode(3, TreeNode(1, None, TreeNode(2)), TreeNode(4)), 1))