class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        M = [[0] * n for _ in range(m)]
        for i in range(m):
            M[i][0] = 1
        for i in range(1, n):
            M[0][i] = 1
        for i in range(1, m):
            for j in range(1, n):
                M[i][j] += M[i-1][j] + M[i][j-1]
        return M[m-1][n-1]

        