def solution(board, moves):
    answer = 0
    stack = []
    new_board = [[] for _ in range(len(board[0]))]
    for i in board[-1::-1]: #보드판 재정의
        for j in range(len(board[0])):
            if i[j]==0:
                continue
            new_board[j].append(i[j])
            
    
    for i in moves:
        if len(new_board[i-1]):
            item = new_board[i-1].pop()
            if not len(stack):
                stack.append(item)
            elif stack[-1] == item:
                stack.pop()
                answer += 2
            else:
                stack.append(item)
    return answer