from types import List
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l = r = 0
        deq = deque()
        res = []
        while r < len(nums):
            while deq and nums[deq[-1]] < nums[r]: deq.pop()
            deq.append(r)
            if l > deq[0]: deq.popleft()
            if r >= k - 1:
                res.append(nums[deq[0]])
                l += 1
            r += 1
        return res

print(Solution().maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))