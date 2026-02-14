class Node: 
    def __init__(self, key, value: int):
        self.prev = None
        self.next = None
        self.key = key
        self.value = value

class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.store = {}
        self.left, self.right = Node(-1, -1), Node(-1, -1)
        self.left.next, self.right.prev = self.right, self.left

    def remove(self, key: int):
        node = self.store[key]
        pre, nxt = node.prev, node.next
        pre.next, nxt.prev = nxt, pre

    def add(self, key: int):
        node = self.store[key]
        pre, nxt = self.right.prev, self.right
        pre.next, nxt.prev = node, node
        node.prev, node.next = pre, nxt

    def get(self, key: int) -> int:
        if key not in self.store: return -1
        self.remove(key)
        self.add(key)
        return self.store[key].value

    def put(self, key: int, value: int) -> None:
        if key in self.store:
            self.store[key].value = value
            self.remove(key)
            self.add(key)
            return

        self.store[key] = Node(key, value)
        self.add(key)
        if len(self.store) > self.cap:
            lru = self.left.next
            self.remove(lru.key)
            del self.store[lru.key]

print(LRUCache(2).put(1, 1))
print(LRUCache(2).put(2, 2))
print(LRUCache(2).get(1))
print(LRUCache(2).put(3, 3))
print(LRUCache(2).get(2))
print(LRUCache(2).put(4, 4))
print(LRUCache(2).get(1))
print(LRUCache(2).get(3))
print(LRUCache(2).get(4))