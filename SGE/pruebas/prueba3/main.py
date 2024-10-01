from collections import deque

cola = deque([1, 2, 3, 4, 5])

cola.append(6)

for el in cola:

    print(el)


def test() :

    return 1, 2, 3, 4, 5


print(test())


help(help())