from typing import Optional

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        minval = self.minstack[-1] if self.minstack else val
        minval = min(minval, val)
        self.minstack.append(minval)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]

print(MinStack().push(-2))
print(MinStack().push(0))
print(MinStack().push(-3))
print(MinStack().getMin())
print(MinStack().pop())
print(MinStack().top())
print(MinStack().getMin())