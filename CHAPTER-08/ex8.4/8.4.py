# <8.4.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 52분 01초

def simplifyPath(self, path: str) -> str:
    st = []
    dirs = path.split('/')
    for d in dirs:
        if d == "" or d == '.':
            continue
        elif d == '..':
            if len(st) != 0:
                st.pop()
        else:
            st.append(d)
    return '/' + '/'.join(st)
