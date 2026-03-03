from types import List
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deq = deque()
        res = []
        for i, v in enumerate(nums):
            while deq and nums[deq[-1]] < v: deq.pop()
            if deq and deq[0] == i-k: deq.popleft()
            deq.append(i)
            if i >= k-1: res.append(nums[deq[0]])
        return res


print(Solution().maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))