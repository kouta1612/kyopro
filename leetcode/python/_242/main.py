class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)

print(Solution().isAnagram("anagram", "nagaram"))
print(Solution().isAnagram("rat", "car"))