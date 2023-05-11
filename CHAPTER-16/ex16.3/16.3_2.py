class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        M = [[0] * n for _ in range(m)]

        obs_appeared = False
        for i in range(m):
            if obstacleGrid[i][0] == 1:
                obs_appeared = True
            if obs_appeared:
                M[i][0] = 0
            else:
                M[i][0] = 1

        obs_appeared = False

        for i in range(n):
            if obstacleGrid[0][i] == 1:
                obs_appeared = True
            if obs_appeared:
                M[0][i] = 0
            else:
                M[0][i] = 1

        for i in range(1, m):
            for j in range(1, n):                
                M[i][j] += M[i-1][j] + M[i][j-1]
                if obstacleGrid[i][j] == 1:
                    M[i][j] = 0

        return M[m-1][n-1]