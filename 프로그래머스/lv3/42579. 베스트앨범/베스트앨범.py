def solution(genres, plays):
    answer = []
    dic1, dic2 = {i:0 for i in genres}, {i:[] for i in genres}
    list1 = []
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        dic1[genre] += play
        dic2[genre] += [[i,play]]
    for key, val in dic2.items():
        dic2[key].sort(key = lambda x : (-x[1],x[0]))
        while len(val)>2:
            val.pop()
    for key, val in dic1.items():
        list1.append([key,val])
    list1.sort(key = lambda x : -x[1])
    for i in list1:
        genre = i[0]
        for j in dic2[genre]:
            answer.append(j[0])
    return answer