def solution(num, total):
    answer = []
    sum = (num-1)*num//2
    total -= sum
    x = total//num
    for _ in range(num):
        answer.append(x)
        x += 1
        
    return answer