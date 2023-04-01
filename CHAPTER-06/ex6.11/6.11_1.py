
# <6.7.py>
# - 
# - 
# - 
# - 
# Author: Han Jaesung


from typing import List

def print_as_sine(s:str) -> None:
    L = [[' '] * len(s) for _ in range(3)]
    dirs = {1:(-1, 1), -1:(1, 1)}   # y, x
    pos = (1, 0)    # Starting position
    next_dir = 1

    def isValid(y, x) -> bool:
        if 0 <= y < len(L) and 0 <= x < len(L[0]):
            return True
        return False

    for i in range(len(s)):
        y, x = pos
        L[y][x] = s[i] if s[i] != ' ' else '_'
        next_y, next_x = y + dirs[next_dir][0], x + dirs[next_dir][1]
        while i < len(s) - 1 and not isValid(next_y, next_x):
            next_dir *= -1
            next_y, next_x = y + dirs[next_dir][0], x + dirs[next_dir][1]
        pos = (next_y, next_x)
    

    def print_pretty(L:List[List[str]])->None:
        for i in range(len(L)):
            for j in range(len(L[0])):
                print(L[i][j], end = '')
            print()
        return


    def print_answer(L:List[List[str]])->None:
        s = ''
        for i in range(len(L)):
            for j in range(len(L[0])):
                if L[i][j] != ' ':
                    s += L[i][j]
        print(s)
        return

    print_pretty(L)
    print()
    print_answer(L)

if __name__ == '__main__':
#    print_as_sine('Hello world!')
    print_as_sine('Advanced problem solving lecture')
#    print_as_sine('Senior student')