# <6.11_2.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 51분 43초
import re
def string_to_wave(s:str)->str:
    res = ''
    s = re.sub(' ', '_', s) # HELLO WORLD! => HELLO_WORLD
    for i in range(1, len(s), +4):
        res += s[i]
    for i in range(0, len(s), +2):
        res += s[i]
    for i in range(3, len(s), +4):
        res += s[i]
    return res

if __name__ == "__main__":
    print(string_to_wave('Hello world!'))
    print(string_to_wave('Advanced problem solving lecture'))
