def solution(x, n):
    answer = [i*x + x for i in range(n)]
    """
    temp = 0
    for _ in range(n):
        temp += x
        answer.append(temp)
    """
    
    return answer