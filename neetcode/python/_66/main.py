from typing import List

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits[-1] >= 0 and digits[-1] < 9:
            digits[-1] += 1
        else:
            idx = -1
            for i in range(len(digits)-1, -1, -1):
                if digits[i] != 9:
                    idx = i
                    break
                else:
                    digits[i] = 0
            
            if idx == -1:
                digits = [1] + digits
            else:
                digits[idx] += 1

        return digits

print(Solution().plusOne([1,2,3]))