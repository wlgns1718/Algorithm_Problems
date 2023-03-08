def solution(n):
    answer = 0
    for i in range(1,11):
        n /= i
        if n == 1:
            answer = i
            break
        elif n < 1:
            answer = i-1
            break
    return answer