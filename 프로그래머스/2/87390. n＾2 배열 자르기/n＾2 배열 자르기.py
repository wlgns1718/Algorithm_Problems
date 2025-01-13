def solution(n, left, right):
    answer = []
    left_idx = left // n
    left_index = left % n
    cnt = 0
    
    while cnt <= right - left:
        
        if left_index == n-1:
            answer.append(n)
            cnt += 1
            left_index = 0
            left_idx += 1
        else:
            temp = left_index
            for _ in range(temp, left_idx):
                answer.append(left_idx + 1)
                cnt += 1
                left_index += 1
                if cnt > right - left:
                    return answer
            for i in range(left_index + 1, n + 1):
                answer.append(i)
                cnt += 1
                if cnt > right - left:
                    return answer
            left_idx += 1
            left_index = 0

    return answer