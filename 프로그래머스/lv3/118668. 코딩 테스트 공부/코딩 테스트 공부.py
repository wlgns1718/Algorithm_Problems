def solution(alp, cop, problems):#문제(필요 알고력, 필요 코딩력, 증가 알고력, 증가 코딩력, 시간)
    
    answer = 0
    max_alp = 0
    max_cop = 0
    time = 0
    
    #목표 알고력과 코딩력
    for a,b,c,d,e in problems:
        max_alp = max(a,max_alp)
        max_cop = max(b,max_cop)
        time += e
    
    #초기 알고력과 코딩력 설정
    alp = min(alp,max_alp)
    cop = min(cop,max_cop)
    INF = float('inf')
    #dp[i][j] = cost 목표 알고력i와 목표 코딩력 j의 cost가 최소가 되는 dp 값
    dp = [[INF]*(max_cop+1) for _ in range(max_alp+1)]
    #dp초기값 설정
    dp[alp][cop] = 0 #최초 코스트 0

    for i in range(alp, max_alp+1): #초기 알고력부터 목표 알고력까지
        for j in range(cop, max_cop+1):#초기 코딩력부터 목표 코딩력까지
            if (i + 1) <= max_alp: #목표 알고력보다 낮으면 1증가하는 경우
                dp[i+1][j] = min(dp[i][j]+1,dp[i+1][j])
            if (j+1) <= max_cop:#목표 코딩력보다 낮으면 1증가하는 경우
                dp[i][j+1] = min(dp[i][j]+1,dp[i][j+1])
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req: #문제 풀기 가능할 때
                    next_alp = min(max_alp, i+alp_rwd)
                    next_cop = min(max_cop, j + cop_rwd)
                    dp[next_alp][next_cop] = min(dp[next_alp][next_cop],dp[i][j] + cost)
    
    return dp[-1][-1]