from itertools import permutations
 
 
T = int(input())
for test_case in range(1,T+1):
    N = int(input())
    arr = list(map(int,input().split()))
    start = arr[:2]
    end = arr[2:4]
    l = arr[4:]
    home = []
    for i in range(len(l)//2):
        temp = i*2
        home.append((l[temp],l[1+temp]))
    all_case = permutations(home,len(home))
    answer = []
    for temp in all_case:
        res = 0
        res += abs(start[0]-temp[0][0])
        res += abs(start[1] - temp[0][1])
        for i in range(len(temp)-1):
            res += abs(temp[i][0]-temp[i+1][0])
            res += abs(temp[i][1] - temp[i+1][1])
        res += abs(temp[-1][0]-end[0])
        res += abs(temp[-1][1]-end[1])
        answer.append(res)
    print('#{0} {1}'.format(test_case,min(answer)))