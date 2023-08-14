import sys

input = sys.stdin.readline

answer = 0

dic = {}

password = list(map(str,input().rstrip()))
for i in range(len(password)):
    dic[password[i]] = i + 1

target = input().rstrip()

l = len(password)
val = 1
for i in range(len(target)-1,-1,-1):
    answer += (dic[target[i]]*val) % 900528
    val = (val * l) % 900528
print(answer % 900528)