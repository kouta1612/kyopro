class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if "0" in [num1, num2]: return "0"

        num1, num2 = num1[::-1], num2[::-1]
        res = [0] * (len(num1) + len(num2))
        for i in range(len(num1)):
            for j in range(len(num2)):
                res[i + j] += int(num1[i]) * int(num2[j])
                res[i + j + 1] += res[i + j] // 10
                res[i + j] = res[i + j] % 10
        res, base = res[::-1], 0
        while base < len(res) and res[base] == 0:
            base += 1
        res = map(str, res[base:])
        return "".join(res)

print(Solution().multiply("123", "456"))