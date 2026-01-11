from types import List
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        res = []
        for i, num in enumerate(nums):
            while dq and nums[dq[-1]] <= num: dq.pop()
            dq.append(i)
            if dq[0] <= i - k: dq.popleft()
            if i >= k - 1: res.append(nums[dq[0]])
        return res

print(Solution().maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))