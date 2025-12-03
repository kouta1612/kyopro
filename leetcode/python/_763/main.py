from types import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        counter = {}
        for c in s: counter[c] = 1 + counter.get(c, 0)
        l, r = 0, 0
        wordset = set()
        res = []
        while r < len(s):
            wordset.add(s[r])
            counter[s[r]] -= 1
            if counter[s[r]] == 0:
                wordset.remove(s[r])
                if len(wordset) == 0:
                    res.append(r + 1 - l)
                    l = r + 1
            r += 1
        return res