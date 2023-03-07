import sys

input = sys.stdin.readline

string = input().strip()
dict = {chr(i):-1 for i in range(97,123)}
for i in range(len(string)):
    if dict[string[i]] == -1:
        dict[string[i]] = i
print(*dict.values())