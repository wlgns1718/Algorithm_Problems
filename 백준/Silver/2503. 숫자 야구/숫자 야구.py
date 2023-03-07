n = int(input())
all_case = [list(map(str,input().split())) for _ in range(n)]
answer = []
for a in range(1,10):#백의 자리
    a = str(a)
    for b in range(1,10): #십의 자리
        b = str(b)
        for c in range(1,10): #일의 자리
            c = str(c)
            if (a==b) or (b==c) or (c==a):
                continue

            cnt = 0
            for case in all_case:
                strike_cnt = 0
                ball_cnt = 0
                num, strike, ball = case[0], case[1],case[2]
                if num[0] == a:
                    strike_cnt +=1
                if num[1] == b:
                    strike_cnt +=1
                if num[2] == c:
                    strike_cnt +=1
                if (a==num[1] or a == num[2]):
                    ball_cnt +=1
                if (b==num[0] or b == num[2]):
                    ball_cnt +=1
                if (c==num[1] or c == num[0]):
                    ball_cnt +=1
                if int(strike) == strike_cnt and int(ball) == ball_cnt:
                    cnt +=1
            if cnt == n:
                answer.append(int(a+b+c))
print(len(answer))