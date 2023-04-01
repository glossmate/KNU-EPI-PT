# <4.9_1.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 51분 13초
import time


# O(n)
def isPalindrome1(s: str) -> bool:
    left = 0
    right = len(s) - 1
    while left < right and s[left] == s[right]:
        left += 1
        right -= 1
    if left < right:
        return False
    return True


# slicing => 속도가 위의 코드보다 훨씬 빠릅니다.
def isPalindrome2(s: str) -> bool:
    return s == s[::-1]




if __name__ == "__main__":
    s = time.time()
    n = 333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
    print(isPalindrome1(str(n)))
    e = time.time()
    one = e - s
    s = time.time()
    print(isPalindrome2(str(n)))
    e = time.time()
    two = e - s
    print('1 vs 2 = ', one, two)
