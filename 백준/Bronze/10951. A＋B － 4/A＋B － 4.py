import sys
values = sys.stdin.readlines()
for value in values:
    a, b = map(int, value.split())
    print(a+b)