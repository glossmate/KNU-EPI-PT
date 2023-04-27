from typing import *

def findKthLargest(nums: List[int], k: int) -> int:
    """Quickselect"""
    pivot = choice(nums)  # 랜덤하게 pivot 을 구한다.

    greater, equal, smaller = [], [], []
    for n in nums:
        if n > pivot:
            greater.append(n)
        elif n == pivot:
            equal.append(n)
        else:
            smaller.append(n)

    # k번째 큰 원소가 greater list 안에 있다면
    if len(greater) >= k:
        return findKthLargest(greater, k)

    # k번째 큰 원소가 equal list 안에 있다면
    if len(greater) + len(equal) >= k:
        return equal[0]

    # k번째 원소가 smaller 집합에 있다면,
    # smaller 집합에서 k - len(greater) + len(equal) 번째 원소를 구하자.
    return findKthLargest(less, k - len(greater) - len(equal))
