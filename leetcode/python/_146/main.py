class Node:
    def __init__(self, key, value: int):
        self.key, self.value = key, value
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.store = {}
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left

    def remove(self, node: Node):
        prev, nxt = node.prev, node.next
        prev.next, nxt.prev = nxt, prev

    def insert(self, node: Node):
        prev, nxt = self.right.prev, self.right
        prev.next = nxt.prev = node
        node.prev, node.next = prev, nxt

    def get(self, key: int) -> int:
        if key in self.store: 
            self.remove(self.store[key])
            self.insert(self.store[key])
            return self.store[key].value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.store:
            self.remove(self.store[key])
        self.store[key] = Node(key, value)
        self.insert(self.store[key])
        if len(self.store) > self.cap:
            lru = self.left.next
            self.remove(lru)
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