from typing import List
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        uniq, visited, q = set(wordList), set([beginWord]), deque([beginWord])
        res = 1
        if endWord not in uniq:
            return 0
        
        while len(q) > 0:
            size = len(q)
            for _ in range(size):
                word = q.popleft()
                if word == endWord: return res
                for i in range(len(word)):
                    for j in range(ord('a'), ord('z') + 1):
                        w = word[:i] + chr(j) + word[i + 1:]
                        if w in uniq and w not in visited:
                            q.append(w)
                            visited.add(w)
            res += 1
        return 0
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))