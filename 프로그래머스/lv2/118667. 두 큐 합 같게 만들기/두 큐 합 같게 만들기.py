from collections import deque
def solution(queue1, queue2):
    answer = 0
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    total = sum1 + sum2
    que1 = deque(queue1)
    que2 = deque(queue2)
    stop = -1
    if total % 2 != 0:
        return -1
    else:
        total //=2
    while sum1 != total or sum2 !=total:
        if stop > (len(queue1)*2):
            return -1
        if not len(que1) or not len(que2):
            return -1
        if sum1 < total:
            n = que2.popleft()
            que1.append(n)
            sum2 -= n
            sum1 += n
            answer += 1
            stop += 1
            
        else:
            n = que1.popleft()
            que2.append(n)
            sum1 -= n
            sum2 += n
            answer += 1
            stop += 1
    return answer