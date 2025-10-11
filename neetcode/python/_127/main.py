from typing import List
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0

        wordSet, seen, q, res = set(wordList), set(), deque([beginWord]), 1
        while len(q) > 0:
            size = len(q)
            for _ in range(size):
                v = q.popleft()
                if v == endWord: return res
                for i in range(len(v)):
                    for o in range(ord('a'), ord('z') + 1):
                        s = v[:i] + chr(o) + v[i+1:]
                        if s in wordSet and s not in seen:
                            q.append(s)
                            seen.add(s)
            res += 1
        return 0

print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))