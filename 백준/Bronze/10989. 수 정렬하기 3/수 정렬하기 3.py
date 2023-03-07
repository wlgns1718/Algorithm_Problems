import sys

input = sys.stdin.readline

N = int(input())
dict = {i:0 for i in range(10001)}

for _ in range(N):
    dict[int(input())] += 1

for key,value in dict.items():
    for _ in range(value):
        print(key)