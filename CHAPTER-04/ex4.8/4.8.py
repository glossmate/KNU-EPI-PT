# <4.8.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 51분 01초

# Time Complexity: O(n)? O(logn)
# Space Somplexity: O(n)
def reverseNumber1(n: int) -> int:
    sign = 1
    out = str(n)  # 35 -> "35"
    # -35 -> "-35"

    out = out[::-1]  # "35" -> "53"
    # "-35" -> "53-"

    if n < 0:
        out = out[:-1]  # "53-" -> "53"
        sign = -1

    return sign * int(out)


# Time Complexity: O(n)
# Space Somplexity: O(1)
def reverseNumber2(n: int) -> int:
    # 3212345 -> 5432123
    sign = 1
    if n < 0:
        sign = -1
        n = -n

    s = n % 10
    n //= 10
    while n > 0:
        s = s * 10 + (n % 10)
        n //= 10

    return sign * s

if __name__ == '__main__':
    print(reverseNumber1(26))
    print(reverseNumber1(-26))
    print(reverseNumber2(26))
    print(reverseNumber2(-26))
    print(reverseNumber1(234050))
    print(reverseNumber1(-234050))
    print(reverseNumber2(234050))
    print(reverseNumber2(-234050))
