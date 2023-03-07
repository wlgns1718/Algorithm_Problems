import sys
num = int(input())
str1 = sys.stdin.readline()
answer = 0
alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
hashing = {alpha[i] : i+1 for i in range(26)}
for i in range(num):
    answer += hashing[str1[i]]*(31**i)
print(answer)