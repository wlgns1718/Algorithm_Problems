from collections import deque
def solution(n, edge):
    answer = 0
    que = deque()
    edge.sort()
    distance = [0]*(n+1)
    route = [[]for i in range(n+1)]
    for i in edge:
        route[i[0]].append(i[1])
        route[i[1]].append(i[0])
    que.append(1)
    while que:
        cur = que.popleft()
        for i in route[cur]:
            if distance[i] == 0:
                que.append(i)
                distance[i] = distance[cur]+1
    distance[1] = 0
    max_dis = max(distance)
    for i in distance:
        if i == max_dis:
            answer += 1
            
    return answer