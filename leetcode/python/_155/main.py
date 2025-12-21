from typing import Optional

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(self.minStack[-1], val) if self.minStack else val
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]

print(MinStack().push(-2))
print(MinStack().push(0))
print(MinStack().push(-3))
print(MinStack().getMin())
print(MinStack().pop())
print(MinStack().top())
print(MinStack().getMin())