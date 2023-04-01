# <16.1_1.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 50분 25초

points = [2, 3, 7]
res = []
path = []
def score( k:int, p:int, target:int):
    if k == target:
        res.append(list(path))
        return
    
    for i in range(p, len(points)):

        if k + points[i] > target:
            break

        path.append(points[i])
        score(k + points[i], i, target)
        path.pop()

points.sort()
score(0, 0, 12)
print('score(12) = ', len(res))
print(res)
