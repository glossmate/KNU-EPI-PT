# <4.9_2.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 51분 21초
import math


def getDigit1(n: int) -> int:
    return len(str(n))


def getDigit2(n: int) -> int:
    d = 0
    while n > 0:
        n //= 10
        d += 1
    return d


def isPalindrome(n: int) -> bool:
    if n < 0:
        return False
    if n == 0:
        return True
    d = math.floor(math.log(n, 10)) + 1
    right = n % 10
    left = n // (10**(d - 1))
    while d > 1:
        if left != right:
            return False
        n -= left * (10**(d - 1))
        n //= 10
        d -= 2
        left = n // 10**(d - 1)
        right = n % 10
    return True


print(isPalindrome(1218121))
