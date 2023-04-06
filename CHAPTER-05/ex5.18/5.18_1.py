def visit_spiral1(n):
    # right, down, left, up
    dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    idx = 0
    cnt = 0
    i = j = 0
    while(True):
        print(i, j, A[i][j])
        cnt += 1
        if cnt >= n * n:
            break
        next_i = i + dirs[idx][0]
        next_j = j + dirs[idx][1]
        while not (0 <= next_i < n and 0 <= next_j < n):
            idx = (idx + 1) % len(dirs)
            next_i = i + dirs[idx][0]
            next_j = j + dirs[idx][1]
        i = next_i
        j = next_j

def visit_spiral2(n):
    # right, down, left, up
    dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    idx = 0
    cnt = 0
    i = j = 0
    while(True):
        print(i, j, A[i][j])
        A[i][j] = -1 # Mark as visited
        cnt += 1
        if cnt >= n * n:
            break
        next_i = i + dirs[idx][0]
        next_j = j + dirs[idx][1]
        while not (0 <= next_i < n and 0 <= next_j < n) or A[next_i][next_j] == -1:
            idx = (idx + 1) % len(dirs)
            next_i = i + dirs[idx][0]
            next_j = j + dirs[idx][1]
        i = next_i
        j = next_j

def visit_spiral3(n):
    # right, down, left, up
    dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    idx = 0
    cnt = 0
    i = j = 0
    visited = set()
    while(True):
        print(i, j, A[i][j])
        visited.add((i,j))
        cnt += 1
        if cnt >= n * n:
            break
        next_i = i + dirs[idx][0]
        next_j = j + dirs[idx][1]
        while not (0 <= next_i < n and 0 <= next_j < n) or (next_i, next_j) in visited:
            idx = (idx + 1) % len(dirs)
            next_i = i + dirs[idx][0]
            next_j = j + dirs[idx][1]
        i = next_i
        j = next_j

# Array initialization
n = 3
A = [[0] * n for _ in range(n)]
k = 1
for i in range(n):
    for j in range(n):
        A[i][j] = k
        k += 1

visit_spiral1(n)
print('--')
visit_spiral3(n)
print('--')
visit_spiral2(n)
print('--')
