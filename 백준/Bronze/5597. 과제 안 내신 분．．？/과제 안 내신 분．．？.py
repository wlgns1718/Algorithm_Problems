import sys

input = sys.stdin.readline

dic = set([i for i in range(1, 31)])


for _ in range(28):
    a = int(input())
    if a in dic:
        dic.remove(a)

for i in dic:
    print(i)