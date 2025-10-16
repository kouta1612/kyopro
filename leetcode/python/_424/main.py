from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        dic = defaultdict(int)
        j, res = 0, 0
        for i in range(len(s)):
            while j < len(s):
                dic[s[j]] += 1
                maxNum = 0
                for num in dic.values():
                    maxNum = max(maxNum, num)
                remain = (j - i + 1) - maxNum
                if remain <= k: j += 1
                else:
                    dic[s[j]] -= 1
                    break
            res = max(res, j - i)
            dic[s[i]] -= 1
        return res

print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))