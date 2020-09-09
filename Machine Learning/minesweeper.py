row, col = map(int, input().split())
matrix = []

for i in range(row):
    matrix.append(list(input()))

for i in range(len(matrix)):
    for j in range(len(matrix[i])):
        if matrix[i][j] == '.':
            target = [matrix[k][j-1 if j>0 else 0: j+2 if j<len(matrix[i])-1 else len(matrix)].count('*')
                      for k in range(i-1 if i>0 else 0, i+2 if i<len(matrix)-1 else len(matrix))]
            matrix[i][j] = sum(target)

for i in range(len(matrix)):
    for j in range(len(matrix[i])):
        print(matrix[i][j], end='')
    print()
