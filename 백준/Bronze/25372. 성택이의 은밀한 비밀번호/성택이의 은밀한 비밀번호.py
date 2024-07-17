import sys

input = sys.stdin.readline

N = int(input())

for _ in range(N):
    word = input().strip()
    if 6 <= len(word) <= 9:
        print("yes")
    else:
        print("no")