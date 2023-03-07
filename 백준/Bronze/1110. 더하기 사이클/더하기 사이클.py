def solution(a, N):
    if a < 10:
        list1 = [int(i) for i in str(a)]
        list1.insert(0, 0)
        New = list1[0]+list1[1]
        New_list = [int(i) for i in str(New)]
        result = [list1[-1],New_list[-1]]
        return int(''.join(map(str,result))),N+1
    else:
        list1 = [int(i) for i in str(a)]
        New = list1[0] + list1[1]
        New_list = [int(i) for i in str(New)]
        result = [list1[-1], New_list[-1]]
        return int(''.join(map(str, result))), N+1

a= None
a = int(input())
N = 0
sol, N = solution(a,N)
while a != sol:
    sol, N = solution(sol,N)
print(N)