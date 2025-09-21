class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if s == t:
            return True
        ti = 0
        for i in range(len(s)):
            found = False
            for j in range(ti, len(t)):
                if s[i] == t[j]:
                    ti = j + 1
                    found = True
                    break
            if not found:
                return False
        return True

print(Solution().isSubsequence("abc", "ahbgdc"))
print(Solution().isSubsequence("axc", "ahbgdc"))
print(Solution().isSubsequence("abc", "abc"))
print(Solution().isSubsequence("abc", "abc"))