# <5.6.py>
# - 
# - 
# Author: Han Jaesung
# 2023년 04월 01일 (토) 오후 03시 51분 28초
from typing import List

def maxProfit(L:List[int])->int:
    max_profit = 0
    for i in range(len(L)):
        for j in range(i + 1, len(L)):
            max_profit = max(max_profit, L[j] - L[i])
    return max_profit


def maxProfit2(L:List[int])->int:
    INT_MAX = 10987654321
    max_profit = 0
    min_price = INT_MAX
    for i in range(len(L)):
        max_profit = max(max_profit, L[i] - min_price)
        min_price = min(min_price, L[i])
    return max_profit
