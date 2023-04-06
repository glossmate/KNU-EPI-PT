def recursive_spiral(i, j, n):
    if n == 0:
        print('--')
        return
    if n == 1:
        print(i, j, A[i][j])
        print('--')
        return
    for k in range(j, j + n - 1):
        print(i, k, A[i][k])
    for k in range(i, i + n - 1):
        print(k, j + n - 1, A[k][j + n - 1])
    for k in range(j + n - 1, j, -1):
        print(n - 1 - i, k, A[n - 1 - i][k])
    for k in range(n - 1 - i, i, -1):
        print(k, j, A[k][j])
    recursive_spiral(i + 1, j + 1, n - 2)

# Array initialization
n = 3
A = [[0] * n for _ in range(n)]
k = 1
for i in range(n):
    for j in range(n):
        A[i][j] = k
        k += 1
recursive_spiral(0, 0, n)
