from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) == 0:
            return None
        i = len(nums)//2
        res = TreeNode(nums[i])
        res.left = self.sortedArrayToBST(nums[:i])
        res.right = self.sortedArrayToBST(nums[i+1:])
        return res

print(Solution().sortedArrayToBST([-10,-3,0,5,9]))