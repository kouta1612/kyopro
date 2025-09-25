from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        mapLevelToValue = dict()

        def dfs(root: Optional[TreeNode], level: int):
            if not root:
                return
            mapLevelToValue[level] = mapLevelToValue.get(level, []) + [root.val]
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        dfs(root, 0)
        res = [[]] * len(mapLevelToValue)
        print(mapLevelToValue)
        for k, v in mapLevelToValue.items():
            res[k] = v
        return res
        
print(Solution().levelOrder(None))