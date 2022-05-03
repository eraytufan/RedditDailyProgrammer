import sys

def phonedrop(n, k):
    if 1 in (n, k):
        return k

    minValue = sys.maxsize

    for i in range(1, k + 1):
        maxValue = max(phonedrop(n - 1, i - 1),
                  phonedrop(n, k - i))
        if (maxValue < minValue):
            minValue = maxValue

    return minValue + 1


def test():
    assert phonedrop(1, 100) == 100
    assert phonedrop(2, 12) == 5
    assert phonedrop(3, 20) == 5