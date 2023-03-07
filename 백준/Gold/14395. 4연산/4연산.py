from collections import deque
import sys

def sol(queue,t):
    visit= set()
    answer = []
    while queue:
        cur = queue.popleft()
        visit.add(cur[0])
        if cur[0] + cur[0] == t :
            answer.append(cur[1]+'+')
        else:
            if cur[0]*2 <= t and cur[0]*2 not in visit:
                queue.append([cur[0]*2,cur[1]+'+'])
        if cur[0] * cur[0] == t:
            answer.append(cur[1]+'*')
        else:
            if cur[0]**2 <= t and cur[0]**2 not in visit:
                queue.append([cur[0]**2,cur[1]+'*'])
        if cur[0] - cur[0] == t :
            answer.append(cur[1]+'-')
        else:
            if 0 not in visit:
                queue.append([0,cur[1]+'-'])
        if 1 == t :
            answer.append(cur[1]+'/')
        else:
            if 1 not in visit:
                queue.append([1,cur[1]+'/'])
    return answer

input = sys.stdin.readline

s,t = map(int,input().split())

queue = deque()

queue.append([s,''])
queue.append([1,'/'])

if s==t:
    print(0)
else:
    answer = sol(queue,t)
    if not answer:
        print(-1)
    else:
        answer.sort(key=lambda x:(len(x),x))
        print(answer[0])
