import sys
from collections import deque

def pop(queue):
    return queue.popleft()
def move_left(queue):
    a = queue.popleft()
    queue.append(a)
    return queue
def move_right(queue):
    a = queue.pop()
    queue.appendleft(a)
    return queue

N, count = map(int,sys.stdin.readline().split())
cnt = 0
queue = deque(i for i in range(1,N+1))
ls = list(map(int,sys.stdin.readline().split(" ")))
for i in ls:
    mid = (len(queue)//2)
    idx = queue.index(i)
    if idx <= (mid):
        while queue[0] != (i):
            move_left(queue)
            cnt += 1
        pop(queue)
    else:
        while queue[0] != (i):
            move_right(queue)
            cnt += 1
        pop(queue)
print(cnt)