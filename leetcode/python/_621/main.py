from typing import List
from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counter = Counter(tasks)
        maxFreq = max(counter.values())
        numMaxFreq = list(counter.values()).count(maxFreq)
        return max(len(tasks), (maxFreq - 1) * (n + 1) + numMaxFreq)

print(Solution().leastInterval(["A","A","A","B","B","B"], 2))