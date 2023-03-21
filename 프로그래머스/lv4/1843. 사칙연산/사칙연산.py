def solution(arr):
    answer = 0
    min_max = [0,0]
    sum_number = 0
    for i in range(len(arr)-1,-1,-1):
        if arr[i] == "+":
            continue
        elif arr[i] == "-":
            temp_min, temp_max = min_max
            min_max[0] = min(-sum_number+temp_min,-(sum_number+temp_max))
            cur_number = int(arr[i+1])
            min_max[1] = max(-(sum_number+temp_min),-cur_number+(sum_number-cur_number)+temp_max)
            sum_number = 0
        else:
            sum_number += int(arr[i])
    min_max[1] += sum_number
    answer = min_max[1]
    return answer