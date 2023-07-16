import sys

input = sys.stdin.readline

def check1(number):
    start = 2
    end = number-2
    while start < end:
        if prime[start] and prime[end]:
            return True
        start += 1
        end -= 1

    return False

def check2(number):
    div = number
    while div % M == 0:
        div //= M

    for t in range(2, int(div ** 0.5) + 1):
        if prime[t]:
            if div % t == 0:
                if prime[div//t]:
                    return True
    return False

def sol(idx, number):
    global answer
    if idx == K:
        
        if check1(int(number)) and check2(int(number)):
            answer += 1
        return
    for n in range(10):
        if str(n) in number: continue
        number += str(n)
        sol(idx+1,number)
        number = number[:-1]


K, M = map(int,input().split())

prime = [True] * 98766
i = 2
prime[0] = False
prime[1] = False
while i < 98766:
    if not prime[i]:
        i += 1
        continue
    for j in range(i+i, 98766, i):
        prime[j] = False
    if i > 3:
        i += 2
        continue
    i += 1

answer = 0

for i in range(1,10):
    sol(1, str(i))
print(answer)
