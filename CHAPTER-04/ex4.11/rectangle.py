from typing import List


class Rectangle():
    def __init__(self, x=0, y=0, w=0, h=0):
        self.x = x
        self.y = y
        self.w = w
        self.h = h

    def to_rectangle(self):
        return (self.x, self.y), self.w, self.h

def is_intersect(R1: Rectangle, R2: Rectangle):
    return (R1.x <= R2.x + R2.w) and (R1.x + R1.w >= R2.x) \
        and (R1.y <= R2.y + R2.h) and (R1.y + R1.h >= R2.y)


def simple_find(P: List[int], i: int) -> int:
    while P[i] >= 0:
        i = P[i]
    return i


def collapsing_find(P: List[int], x: int) -> int:
    parent = simple_find(P, x)
    while x != parent:
        y = P[x]
        P[x] = parent
        x = y
    return parent


def simple_union(P: List[int], i: int, j: int) -> None:
    # 주의 : i, j는 항상 root여야 함.
    P[i] = j


def weighted_union(P: List[int], left_root: int, right_root: int) -> None:
    if P[left_root] <= P[right_root]:
        P[left_root] += P[right_root]
        P[right_root] = left_root
    elif P[left_root] > P[right_root]:
        P[right_root] += P[left_root]
        P[left_root] = right_root


if __name__ == "__main__":
    L1 = [Rectangle(1, 1, 10, 10), Rectangle(15, 20, 30, 20), Rectangle(25, 15, 10, 35),
         Rectangle(70, 100, 25, 45), Rectangle(85, 33, 50, 20), Rectangle(120, 100, 25, 33)]

    L2 = [Rectangle(1, 1, 10, 10), Rectangle(12, 20, 30, 20), Rectangle(1, 1, 10, 5),
         Rectangle(70, 100, 25, 45), Rectangle(85, 33, 50, 20), Rectangle(120, 100, 25, 33)]

    L = L1
    # Step 1
    for i in range(len(L)):
        for j in range(i + 1, len(L)):
            if is_intersect(L[i], L[j]):
                print(f'{i}, {j} -> intersect.')
            else:
                print(f'{i}, {j} -> not intersect.')


    # Step 2
    R = [-1] * len(L)
    print(R)

    for i in range(len(L)):
        for j in range(i + 1, len(L)):
            R1, R2 = L[i], L[j]
            if is_intersect(R1, R2):
                root_left = simple_find(R, i)
                root_right = simple_find(R, j)

                if root_left != root_right:
                    simple_union(R, root_left, root_right)

    print(R)

    d = dict()
    for i in range(len(R)):
        if R[i] < 0:
            if i not in d:
                d[i] = [i]
        else:
            parent = collapsing_find(R, i)
            if parent not in d:
                d[parent] = [parent]
            d[parent].append(i)
    print(d)

    import numpy as np

    import cv2

    # color 설정

    blue_color = (255, 0, 0)

    green_color = (0, 255, 0)

    red_color = (0, 0, 255)

    white_color = (255, 255, 255)

    # 모두 0으로 되어 있는 빈 Canvas(검정색)

    img = np.zeros((384, 384, 3), np.uint8)

    for Rect in L:
        img = cv2.rectangle(img, (Rect.x, Rect.y), (Rect.x + Rect.w, Rect.y + Rect.h), red_color, 3)
        img = cv2.rectangle(img, (Rect.x, Rect.y), (Rect.x + Rect.w, Rect.y + Rect.h), blue_color, -1)
    cv2.imshow('rectangle', img)

    cv2.waitKey(0)

    cv2.destroyAllWindows()
