class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m, n = len(s1), len(s2)
        if m > n: return False

        counter1, counter2 = [0] * 26, [0] * 26
        for i in range(m):
            counter1[ord(s1[i]) - ord('a')] += 1
            counter2[ord(s2[i]) - ord('a')] += 1
        if counter1 == counter2: return True
        for i in range(m, n):
            counter2[ord(s2[i]) - ord('a')] += 1
            counter2[ord(s2[i-m]) - ord('a')] -= 1
            if counter1 == counter2: return True
        return False

print(Solution().checkInclusion("ab", "eidbaooo"))