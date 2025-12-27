class Node:
    def __init__(self, key, val: int):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.store = {}
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next = self.right
        self.right.prev = self.left

    def insert(self, node: Node):
        prev = self.right.prev
        prev.next = node
        node.prev = prev
        node.next = self.right
        self.right.prev = node

    def remove(self, node: Node):
        prev = node.prev
        nxt = node.next
        prev.next, nxt.prev = nxt, prev

    def get(self, key: int) -> int:
        if key not in self.store: return -1

        node = self.store[key]
        self.remove(node)
        self.insert(node)

        return self.store[key].val

    def put(self, key: int, value: int) -> None:
        if key in self.store: self.remove(self.store[key])
        node = Node(key, value)
        self.store[key] = node
        self.insert(node)
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