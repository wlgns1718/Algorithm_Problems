import sys

input = sys.stdin.readline
mersh = []
answer = 0
mersh_sum = [0]*11
for i in range(10):
    mersh.append(int(input()))
    mersh_sum[i+1] = mersh[i]+mersh_sum[i]
for i in mersh_sum:
    if abs(100-i) <= abs(answer-100):
        answer = i
print(answer)