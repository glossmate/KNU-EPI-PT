# <6.5.py>
# - 
# - flip all the words in a sentence.
# - 
# - 
# Author: Han Jaesung
# 2023년 03월 23일 (목) 오후 12시 09분 56초

# Time complexity: O(2n)
# Space complexity: O(n)
# split 함수 직접 구현해보기
def flip1(s:str) -> str:
    L = [] 
    word = ''
    for c in s:
        if c == ' ':
            L.append(word)
            word = ''
        else:
            word += c
    L.append(word)      # 맨 마지막 word까지 배열에 추가해주기

    L = L[::-1]         # word 배열 뒤집기
    return ' '.join(L)  # 배열 각 원소 사이에 스페이스를 넣어 문자열로 리턴

# Time complexity: O(n)
# Space complexity: O(w), w = max word length
# Stack 을 사용해보기
def flip2(s:str) -> str:
    stack = []
    result = ''
    for i in range(len(s)-1, -1, -1):
        c = s[i]
        if c == ' ':
            while stack:
                result += stack.pop()
            result += ' '
        else:
            stack.append(c)
    while stack:
        result += stack.pop()
    return result

# 내부 함수 이용
def flip3(s:str) -> str:
    L = s.split()
    return ' '.join(L[::-1])

if __name__ == '__main__':
    s = 'ALice likes Bob'
    print(flip1(s))
    print(flip2(s))
    print(flip3(s))

