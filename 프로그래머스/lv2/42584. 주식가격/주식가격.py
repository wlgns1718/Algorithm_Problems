from collections import deque
def solution(prices):
    answer = [0]*len(prices)
    
    que = deque()
    for idx, val in enumerate(prices):
        if not que:
            que.append(idx)
            continue
        while que and prices[que[-1]] > val:
            temp = que.pop() 
            answer[temp] = idx - temp
        
        que.append(idx)
    while que:
        temp = que.pop()
        answer[temp] = len(prices) - temp - 1
    
    
        
    return answer