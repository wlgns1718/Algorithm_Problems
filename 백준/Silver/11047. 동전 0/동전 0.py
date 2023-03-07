N, k = map(int,input().split())
sol_list = []
count = 0
for i in range(N):
    val = int(input())
    sol_list.append(val)
sol_list.reverse()
for coin in sol_list:
    if coin <= k:
        count += k//coin
        k %= coin
print(count)