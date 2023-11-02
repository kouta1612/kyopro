package main

import "fmt"

type timestamp struct {
	in, out int
}

func main() {
	var n int
	fmt.Scan(&n)

	g := make([][]int, n)
	for i := 0; i < n; i++ {
		var u, k int
		fmt.Scan(&u, &k)
		u--

		v := make([]int, k)
		for j := 0; j < k; j++ {
			fmt.Scan(&v[j])
			v[j]--
		}

		g[i] = v
	}

	visited := make([]bool, n)
	timestamps := make([]timestamp, n)
	count := 1
	for i := 0; i < n; i++ {
		if !visited[i] {
			dfs(i, g, visited, timestamps, &count)
		}
	}

	for i := 0; i < len(timestamps); i++ {
		fmt.Println(i+1, timestamps[i].in, timestamps[i].out)
	}
}

func dfs(n int, g [][]int, visited []bool, timestamps []timestamp, count *int) {
	if visited[n] {
		return
	}

	timestamps[n].in = *count
	visited[n] = true
	*count++

	for i := 0; i < len(g[n]); i++ {
		dfs(g[n][i], g, visited, timestamps, count)
	}

	timestamps[n].out = *count
	*count++
}
