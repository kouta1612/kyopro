package main

import (
	"fmt"
	"sort"
)

type player struct {
	point         int
	solveProblems []int
}

type problem struct {
	point int
	index int
}

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	a := make([]int, m)
	for i := 0; i < m; i++ {
		fmt.Scan(&a[i])
	}

	s := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&s[i])
	}

	players := make([]player, n)
	for i := 0; i < n; i++ {
		players[i] = player{point: i + 1, solveProblems: []int{}}
		for j := 0; j < m; j++ {
			if s[i][j] == 'o' {
				players[i].point += a[j]
				players[i].solveProblems = append(players[i].solveProblems, j)
			}
		}
	}

	problems := make([]problem, m)
	for i := 0; i < m; i++ {
		problems[i] = problem{point: a[i], index: i}
	}
	sort.Slice(problems, func(i, j int) bool {
		return problems[i].point > problems[j].point
	})

	maxPoint := 0
	maxPlayer := 0
	for i := 0; i < n; i++ {
		if maxPoint < players[i].point {
			maxPoint = players[i].point
			maxPlayer = i
		}
	}

	for i := 0; i < n; i++ {
		result := 0
		for j := 0; j < m; j++ {
			if maxPlayer == i {
				continue
			}
			if players[i].point > maxPoint {
				continue
			}
			found := false
			for k := 0; k < len(players[i].solveProblems); k++ {
				if players[i].solveProblems[k] == problems[j].index {
					found = true
				}
			}
			if found {
				continue
			}

			players[i].point += problems[j].point
			players[i].solveProblems = append(players[i].solveProblems, problems[j].index)
			result++
		}
		fmt.Println(result)
	}
}
