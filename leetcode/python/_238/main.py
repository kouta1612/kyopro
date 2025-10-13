from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod, zero = 1, 0
        for num in nums:
            if num == 0:
                zero += 1
                continue
            prod *= num
        if zero >= 2: return [0] * len(nums)

        res = [prod] * len(nums)
        for i in range(len(nums)):
            if zero == 1:
                if nums[i] != 0: res[i] = 0
            else:
                res[i] //= nums[i]
        return res

print(Solution().productExceptSelf([1, 2, 3, 4]))