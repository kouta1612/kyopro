class Solution:
    def firstUniqChar(self, s: str) -> int:
        mp = dict()
        for c in s:
            mp[c] = 1 + mp.get(c, 0)
        for i, c in enumerate(s):
            if mp[c] == 1:
                return i
        return -1

print(Solution().firstUniqChar("leetcode"))
print(Solution().firstUniqChar("loveleetcode"))
print(Solution().firstUniqChar("aabb"))