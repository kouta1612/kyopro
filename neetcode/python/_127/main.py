import string
from typing import List
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        res, wordSet, seen = 1, set(wordList), set()
        q = deque([beginWord])
        while q:
            size = len(q)
            for _ in range(size):
                now = q.popleft()
                if now == endWord: return res
                for i in range(len(now)):
                    for c in string.ascii_lowercase:
                        s = now[:i] + c + now[i + 1:]
                        if s in wordSet and s not in seen:
                            q.append(s)
                            seen.add(s)
            res += 1
        return 0

print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))