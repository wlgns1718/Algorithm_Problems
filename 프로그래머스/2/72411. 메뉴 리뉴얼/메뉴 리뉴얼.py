def solution(orders, course):
    from collections import Counter
    from itertools import combinations
    answer = []
    for c in course:
        temp = []
        for order in orders:
            combi = combinations(sorted(order),c)
            temp += combi
        counter = Counter(temp)
        if len(counter) > 0 and max(counter.values()) > 1:
            answer += [''.join(f) for f in counter if counter[f] == max(counter.values())]
    answer.sort()
    return answer