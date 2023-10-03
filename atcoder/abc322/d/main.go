package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var sc = bufio.NewScanner(os.Stdin)

func nextLine() string {
	sc.Scan()
	return sc.Text()
}

func main() {
	blocks := make([][][]string, 3)
	for i := 0; i < 3; i++ {
		block := make([][]string, 4)
		for j := 0; j < 4; j++ {
			block[j] = strings.Split(nextLine(), "")
		}
		blocks[i] = block
	}

	grid := make([][]string, 4)
	for i := 0; i < 4; i++ {
		grid[i] = []string{".", ".", ".", "."}
	}

	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			if dfs(0, blocks, grid) {
				fmt.Println("Yes")
				return
			}
			clear(grid)
			rotate(blocks[2])
		}
		rotate(blocks[1])
	}

	fmt.Println("No")
}

func clear(grid [][]string) {
	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			grid[i][j] = "."
		}
	}
}

func dfs(n int, blocks [][][]string, grid [][]string) bool {
	if n == 3 {
		for i := 0; i < 4; i++ {
			for j := 0; j < 4; j++ {
				if grid[i][j] == "." {
					return false
				}
			}
		}
		return true
	}

	for i := -3; i <= 3; i++ {
		for j := -3; j <= 3; j++ {
			newGrid := deepCopy(grid)
			if canPut(blocks[n], newGrid, i, j) {
				if dfs(n+1, blocks, newGrid) {
					return true
				}
			}
		}
	}

	return false
}

func canPut(block, grid [][]string, i, j int) bool {
	for x := 0; x < 4; x++ {
		for y := 0; y < 4; y++ {
			if block[x][y] == "." {
				continue
			}
			nx := x + i
			ny := y + j
			if 0 > nx || 3 < nx || 0 > ny || 3 < ny {
				return false
			}
			if grid[nx][ny] == "#" {
				return false
			}
			grid[nx][ny] = "#"
		}
	}
	return true
}

func rotate(input [][]string) {
	copied := deepCopy(input)
	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			input[j][3-i] = copied[i][j]
		}
	}
}

func deepCopy(input [][]string) [][]string {
	result := make([][]string, 4)
	for i := 0; i < 4; i++ {
		result[i] = make([]string, 4)
		copy(result[i], input[i])
	}
	return result
}
