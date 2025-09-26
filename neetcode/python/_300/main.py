from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []

        def lower_bound(arr: List[int], v: int) -> int:
            ng, ok = -1, len(arr)
            while ng + 1 != ok:
                mid = (ok + ng) // 2
                if arr[mid] >= v:
                    ok = mid
                else:
                    ng = mid
            return ok

        for num in nums:
            if not res or (res and res[-1] < num):
                res.append(num)
            else:
                li = lower_bound(res, num)
                res[li] = num
        return len(res)

print(Solution().lengthOfLIS([10,9,2,5,3,7,101,18]))