import sys

input = sys.stdin.readline

n = int(input())
answer = 0

for i in range(2, int(n**0.5) + 1):
    j = n // i
    answer += (j + i) * (j - i + 1) // 2
    answer += (j - i) * i

answer = answer % 1000000
print(answer)