import queue
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        depth, q = 1, queue.Queue()
        q.put(root)
        while not q.empty():
            num = q.qsize()
            for i in range(num):
                now = q.get()
                if not now.left and not now.right:
                    return depth
                if now.left:
                    q.put(now.left)
                if now.right:
                    q.put(now.right)
            depth += 1
        return depth

print(Solution().minDepth(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))