package main

import "fmt"

func main() {
	timeMap := Constructor()
	timeMap.Set("foo", "bar", 1)
	fmt.Println(timeMap.Get("foo", 1))
	fmt.Println(timeMap.Get("foo", 3))
	timeMap.Set("foo", "bar2", 4)
	fmt.Println(timeMap.Get("foo", 4))
	fmt.Println(timeMap.Get("foo", 5))
}

type TimeMap struct {
	store map[string][]model
}

type model struct {
	val  string
	time int
}

func Constructor() TimeMap {
	return TimeMap{store: make(map[string][]model)}
}

func (m *TimeMap) Set(key string, value string, timestamp int) {
	if _, exist := m.store[key]; !exist {
		m.store[key] = make([]model, 0)
	}

	m.store[key] = append(m.store[key], model{val: value, time: timestamp})
}

func (m *TimeMap) Get(key string, timestamp int) string {
	if _, exist := m.store[key]; !exist {
		return ""
	}

	ok, ng := -1, len(m.store[key])
	for ok != ng-1 {
		mid := (ok + ng) / 2
		if m.store[key][mid].time <= timestamp {
			ok = mid
		} else {
			ng = mid
		}
	}

	if ok == -1 {
		return ""
	}

	return m.store[key][ok].val
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */
