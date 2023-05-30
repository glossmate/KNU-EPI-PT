# 2016111818 김우영
# 15.4 powerset

S = {0, 1, 2}


# recursive way
def recursive_power_set(S: set) -> set[frozenset]:
    # if S is empty set
    if len(S) == 0:
        # return set of empty set
        return set([frozenset()])
    _S = S.copy()
    x = _S.pop()
    # powerset without element x
    U = recursive_power_set(_S)
    # subsets with element x
    V = {frozenset(set(_frozenset) | set([x])) for _frozenset in U}
    # return union of U and V
    return U | V


print("----------recursive way----------")
print(recursive_power_set(S))


# another way
def bit_power_set(S: list) -> set[frozenset]:
    from math import log2
    _power_set = set()
    for num in range(2 ** len(S)):
        _subset = set()
        while num != 0:
            # index lowest bit with 1
            index = int(log2(num & ~(num-1)))
            _subset.add(S[index])
            # delete lowest bit with 1
            num &= (num - 1)
        _power_set.add(frozenset(_subset))
    return _power_set


print("----------another way----------")
print(bit_power_set(list(S)))
