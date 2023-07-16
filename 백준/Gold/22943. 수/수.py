from itertools import permutations

def div(n,m):
    while (n % m) == 0:
        n //= m
    return n

def pf_cnt(n):
    fact = 2
    cnt = 0
    while n != 1:
        if fact > int(n**(1/2)):
            break
        if cnt == 2:
            return False
        if n % fact == 0:
            n //= fact
            cnt += 1
        else:
            fact += 1
    if cnt == 1:
        return True
    else:
        return False

def is_prime(n):
    fact = 2
    if n == 1:
        return False
    while fact <= int(n ** (1 / 2)):
        if n % fact == 0:
            return False
        fact += 1
    return True

K, M = map(int, input().split())

temp = permutations(range(10),K)

lst = []

for i in temp:
    if i[0] == 0:
        continue
    lst.append(int(''.join(map(str,i))))

answer = 0

for i in lst:
    if i < 10:
        temp = div(i,M)
        if i == 9 and temp == 9:
            answer +=1
    else:
        temp = div(i,M)
        if i % 2 == 0 or is_prime(i-2):
            if pf_cnt(temp):
                answer += 1
print(answer)