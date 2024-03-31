import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = list(list(map(int, input().split())) for _ in range(n))
brr = list(list(map(int, input().split())) for _ in range(n))

for i in range(n):
    for j in range(m):
        print(arr[i][j] + brr[i][j], end=" ")
    print()