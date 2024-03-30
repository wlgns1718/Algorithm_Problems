import sys

input = sys.stdin.readline
ls = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]
dic = {i+3: ls[i] for i in range(8)}

word = input().strip()
answer = 0
for i in word:
    for idx, val in dic.items():
        if i in val:
            answer += idx
print(answer)