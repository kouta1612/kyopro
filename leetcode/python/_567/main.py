from collections import defaultdict

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n, m = len(s1), len(s2)
        if n > m: return False
        cnt1, cnt2 = [0] * 26, [0] * 26
        for c in s1: cnt1[ord(c) - ord('a')] += 1
        for i in range(n): cnt2[ord(s2[i]) - ord('a')] += 1
        matches = 0
        for i in range(26):
            if cnt1[i] == cnt2[i]: matches += 1
        if matches == 26: return True

        left = 0
        for right in range(n, m):
            l, r = ord(s2[left]) - ord('a'), ord(s2[right]) - ord('a')

            cnt2[r] += 1
            if cnt1[r] == cnt2[r]: matches += 1
            elif cnt1[r] + 1 ==  cnt2[r]: matches -= 1

            cnt2[l] -= 1
            if cnt1[l] == cnt2[l]: matches += 1
            elif cnt1[l] - 1 ==  cnt2[l]: matches -= 1

            if matches == 26: return True

            left += 1
        return False

print(Solution().checkInclusion("ab", "eidbaooo"))