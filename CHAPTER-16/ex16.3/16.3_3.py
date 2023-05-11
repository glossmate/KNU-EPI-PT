if __name__ == '__main__':
    fishmap = [[-1,-1,0,1,-1],[-1,1,2,-1,0],[-1,0,3,0,3],[2,-1,1,-1,2],[1,3,0,-1,2]]
    m, n = len(fishmap), len(fishmap[0])
    M = [[0] * n for _ in range(m)]

    M[0][0] = 0 if fishmap[0][0] == -1 else 1
    for i in range(1, m):
        if fishmap[i][0] > -1:
            M[i][0] = M[i-1][0] + 1
        else:
            M[i][0] = M[i-1][0]
    for i in range(1, n):
        if fishmap[0][i] > -1:
            M[0][i] = M[0][i-1] + 1
        else:
            M[0][i] = M[0][i-1]

    for i in range(1, m):
        for j in range(1, n):
            if fishmap[i][j] > -1:
                M[i][j] = max(M[i-1][j], M[i][j-1]) + 1
            else:
                M[i][j] = max(M[i-1][j], M[i][j-1])
    print(M[m-1][n-1])
    print(M)