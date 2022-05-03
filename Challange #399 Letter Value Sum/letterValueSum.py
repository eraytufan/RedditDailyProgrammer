# returns sum of characters in alphabetic order
def letterSum(word):
    sum = 0
    for char in word:
        sum += ord(char) - 96
    return sum

def test():
    assert(letterSum("microspectrophotometries") == 317)

