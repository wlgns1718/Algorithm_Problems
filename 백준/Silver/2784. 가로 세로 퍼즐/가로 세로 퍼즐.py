def sol(temp, words_dict):
    ls = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8]]
    temp_dict = {}
    for i in ls:
        temp_word = ""
        for j in i:
            temp_word += temp[j]
        if temp_word in words_dict:
            if temp_word not in temp_dict:
                temp_dict[temp_word] = 1
            else:
                temp_dict[temp_word] += 1
        else:
            return False
    for key in words_dict.keys():
        if key not in temp_dict:
            return False
        if temp_dict[key] != words_dict[key]:
            return False
    else:
        return temp


from itertools import permutations

words = []
word_dict = {}
visit = []
for _ in range(6):
    words.append(input())
for i in words:
    if i not in word_dict:
        word_dict[i] = 1
    else:
        word_dict[i] += 1
for i in permutations(words, 3):
    temp = i[0] + i[1] + i[2]
    if sol(temp, word_dict) is not False:
        if sol(temp,word_dict) in visit:
            continue
        visit.append(sol(temp, word_dict))
if visit:
    for i in range(0,9,3):
        print(visit[0][i:i+3])
else:
    print(0)
