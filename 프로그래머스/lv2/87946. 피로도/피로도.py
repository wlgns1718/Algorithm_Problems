from itertools import permutations

def solution(k, dungeons):
    answer = -1
    l = [i for i in range(len(dungeons))]
    
    case = set(permutations(l,len(dungeons)))
    for c in case:
        cnt = 0
        pirodo = k
        for idx in c:
            if dungeons[idx][0] <= pirodo:
                pirodo -= dungeons[idx][1]
                cnt += 1
        answer = max(answer, cnt)
        
    return answer