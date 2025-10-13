package main

import "fmt"

func main() {
	fmt.Println(searchMatrix([][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3))
	fmt.Println(searchMatrix([][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13))
}

func searchMatrix(matrix [][]int, target int) bool {
	top, bot := 0, len(matrix)-1
	for top <= bot {
		mid := (top + bot) / 2
		if target < matrix[mid][0] {
			bot = mid - 1
		} else if target > matrix[mid][len(matrix[0])-1] {
			top = mid + 1
		} else {
			break
		}
	}

	if top > bot {
		return false
	}

	l, r := 0, len(matrix[0])-1
	i := (top + bot) / 2
	for l <= r {
		mid := (l + r) / 2
		if target > matrix[i][mid] {
			l = mid + 1
		} else if target < matrix[i][mid] {
			r = mid - 1
		} else {
			return true
		}
	}

	return false
}
