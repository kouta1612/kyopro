from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def helper(left, right: int) -> Optional[TreeNode]:
            if left == right:
                return None
            mid = (left + right) // 2
            root = TreeNode(nums[mid])
            root.left = helper(left, mid)
            root.right = helper(mid + 1, right)
            return root
        return helper(0, len(nums))

print(Solution().sortedArrayToBST([-10,-3,0,5,9]))