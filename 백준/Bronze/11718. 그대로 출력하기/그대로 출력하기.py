import sys

input = sys.stdin.readline
while True:
    word = ""
    word = input()
    if not len(word):
        break
    sys.stdout.write(word)
sys.stdout.flush()