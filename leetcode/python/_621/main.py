from typing import List
from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counter = Counter(tasks)
        max_freq = max(counter.values())
        max_count = sum(1 for v in counter.values() if v == max_freq)
        res = (max_freq - 1) * (n + 1) + max_count
        return max(res, len(tasks))

print(Solution().leastInterval(["A","A","A","B","B","B"], 2))