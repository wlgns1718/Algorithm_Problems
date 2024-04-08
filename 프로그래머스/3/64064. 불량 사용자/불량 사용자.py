from itertools import permutations
def solution(user_id, banned_id):
    answer = []
    def check(name,ban):
        if len(name) != len(ban):
            return False
        else:
            for n, b in zip(name,ban):
                if b == '*':
                    continue
                if b != n:
                    return False
            return True
        
    all_case = set(permutations(user_id,len(banned_id)))
    
    for case in all_case:
        for c,b in zip(case, banned_id):
            if check(c,b):
                continue
            else:
                break
        else:
            if set(case) not in answer:
                answer.append(set(case))
    return len(answer)