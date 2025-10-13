package main

import "fmt"

func main() {
	minStack := Constructor()
	minStack.Push(-2)
	minStack.Push(0)
	minStack.Push(-3)
	fmt.Println(minStack.GetMin())
	minStack.Pop()
	fmt.Println(minStack.Top())
	fmt.Println(minStack.GetMin())
}

type MinStack struct {
	stack    []int
	minStack []int
}

func Constructor() MinStack {
	return MinStack{stack: []int{}, minStack: []int{}}
}

func (m *MinStack) Push(val int) {
	m.stack = append(m.stack, val)

	if len(m.minStack) == 0 {
		m.minStack = append(m.minStack, val)
	} else {
		m.minStack = append(m.minStack, min(m.minStack[len(m.minStack)-1], val))
	}
}

func (m *MinStack) Pop() {
	m.stack = m.stack[:len(m.stack)-1]
	m.minStack = m.minStack[:len(m.minStack)-1]
}

func (m *MinStack) Top() int {
	return m.stack[len(m.stack)-1]
}

func (m *MinStack) GetMin() int {
	return m.minStack[len(m.minStack)-1]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
