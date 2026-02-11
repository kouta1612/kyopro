from collections import defaultdict

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m, n = len(s1), len(s2)
        need, window = [0] * 26, [0] * 26
        for c in s1: need[ord(c) - ord('a')] += 1

        left = 0
        for right in range(n):
            window[ord(s2[right]) - ord('a')] += 1
            while right - left + 1 > m:
                window[ord(s2[left]) - ord('a')] -= 1
                left += 1
            if need == window: return True
        print(need, window)
        return False

print(Solution().checkInclusion("ab", "eidbaooo"))