import sys

n, m = map(int, sys.stdin.readline().split())
chess = [] # 8x8 영역별 다시 칠하는 개수 최소값
cnt = []
for _ in range(n):
    chess.append(list(sys.stdin.readline().rstrip()))

for row in range(n-7): # n- 7 + 8 -> n-1 체스판 벗어나지 않도록
    for col in range(m-7):

        cnt1, cnt2 = 0, 0 # 각각 시작 검, 흰일때 다시 칠하는 개수
        for i in range(row, row+8):
            for j in range(col, col+8):
                if (i+j) % 2 == 0:
                    if chess[i][j] == 'B': # 시작 검은색
                        cnt1+=1
                    if chess[i][j] == 'W':
                        cnt2 += 1
                else:
                    if chess[i][j] == 'W': # 시작 흰색
                        cnt1+=1
                    if chess[i][j] == 'B':
                        cnt2 +=1
        cnt.append(min(cnt1, cnt2))  # 8x8 체스판 다시 칠하는 정사각형 최소 개수

print(min(cnt))