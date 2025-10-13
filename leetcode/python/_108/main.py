from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) == 0: return None

        mid = len(nums) // 2
        node = TreeNode(nums[mid])
        left, right = self.sortedArrayToBST(nums[:mid]), self.sortedArrayToBST(nums[mid + 1:])
        node.left, node.right = left, right
        return node

print(Solution().sortedArrayToBST([-10,-3,0,5,9]))