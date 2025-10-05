from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: return None
        
        res = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        res.left = self.buildTree(preorder[1:1+mid], inorder[:mid])
        res.right = self.buildTree(preorder[1+mid:], inorder[mid + 1:])
        return res

print(Solution().buildTree([3,9,20,15,7], [9,3,15,20,7]))