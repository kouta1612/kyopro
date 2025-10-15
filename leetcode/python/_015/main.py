from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        print(nums)
        for i in range(len(nums)-2):
            if i - 1 >= 0 and nums[i-1] == nums[i]: continue
            j, k = i + 1, len(nums) - 1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                if total == 0:
                    res.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while j < k and nums[j - 1] == nums[j]: j += 1
                elif total > 0:
                    k -= 1
                else:
                    j += 1
        return res

print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
print(Solution().threeSum([-4, -1, -1, 0, 1, 2]))