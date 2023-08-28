def solution(n, times):
    answer = 1000000000 * 1000000000 + 1
    start = 0
    while start <= answer:
        temp = 0
        mid = (start+answer) // 2
        for i in range(len(times)):
            temp += mid // times[i]
        if temp >= n:
            answer = mid - 1
        else:
            start = mid + 1
    return answer + 1