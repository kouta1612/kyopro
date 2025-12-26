class TimeMap:
    def __init__(self):
        self.timemap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timemap: self.timemap[key] = []
        self.timemap[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.timemap: return ""
        ok, ng = -1, len(self.timemap[key])
        while abs(ok - ng) > 1:
            wj = (ok + ng) // 2
            if self.timemap[key][wj][1] <= timestamp: ok = wj
            else: ng = wj
        if ok == -1: return ""
        return self.timemap[key][ok][0]

print(TimeMap().get("foo", 1))