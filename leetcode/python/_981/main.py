class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store: return ""
        ok, ng = -1, len(self.store[key])
        while abs(ok - ng) > 1:
            wj = (ok + ng) // 2
            if self.store[key][wj][1] <= timestamp: ok = wj
            else: ng = wj
        return self.store[key][ok][0] if ok >= 0 else ""

print(TimeMap().get("foo", 1))