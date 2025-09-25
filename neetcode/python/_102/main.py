from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        mp, q = dict(), deque()
        q.append([root, 0])

        while len(q) > 0:
            now = q.popleft()
            mp[now[1]] = mp.get(now[1], []) + [now[0].val]
            if now[0].left:
                q.append([now[0].left, now[1] + 1])
            if now[0].right:
                q.append([now[0].right, now[1] + 1])

        res = [[]] * len(mp)
        for k, v in mp.items():
            res[k] = v
        return res
        
print(Solution().levelOrder(None))