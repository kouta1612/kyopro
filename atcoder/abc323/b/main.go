package main

import (
	"fmt"
	"sort"
)

type player struct {
	number   int
	winCount int
}

func main() {
	var n int
	fmt.Scan(&n)

	s := make([]string, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&s[i])
	}

	players := make([]player, n)

	for i := 0; i < n; i++ {
		players[i] = player{number: i + 1, winCount: 0}
		for j := 0; j < n; j++ {
			if s[i][j] == 'o' {
				players[i].winCount += 1
			}
		}
	}

	sort.Slice(players, func(i, j int) bool {
		if players[i].winCount == players[j].winCount {
			return players[i].number < players[j].number
		}
		return players[i].winCount > players[j].winCount
	})

	for i := 0; i < n; i++ {
		if i != n-1 {
			fmt.Print(players[i].number, " ")
		} else {
			fmt.Println(players[i].number)
		}
	}
}
