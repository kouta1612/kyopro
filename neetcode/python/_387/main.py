class Solution:
    def firstUniqChar(self, s: str) -> int:
        mp = dict()
        for c in s:
            if c in mp:
                mp[c] += 1
            else:
                mp[c] = 1
        for i in range(len(s)):
            if mp[s[i]] == 1:
                return i
        return -1

print(Solution().firstUniqChar("leetcode"))
print(Solution().firstUniqChar("loveleetcode"))
print(Solution().firstUniqChar("aabb"))