import sys
input = sys.stdin.readline

arr = []
for _ in range(9):
    num = int(input())
    arr.append(num)
max_num = max(arr)
print(max_num)
print(arr.index(max_num)+1)