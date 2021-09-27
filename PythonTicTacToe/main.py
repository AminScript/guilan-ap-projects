array2d = []

for i in range(3):
    new_line = []
    for j in range(3):
        new_line.append("-")
    array2d.append(new_line)


def show():
    for i in array2d:
        for j in i:
            print(j, end=' ')
        print()

def win():
    for i in range(3):
        if array2d[0][i] == array2d[1][i] == array2d[2][i]:
            if array2d[0][i] == 'x':
                print("X Bord")
                break
            elif array2d[0][i] == 'y':
                print("Y Bord")
                break

    for i in range(3):
        if array2d[i][0] == array2d[i][1] == array2d[i][2]:
            if array2d[i][0] == 'x':
                print("X Bord")
                break
            elif array2d[i][0] == 'y':
                print("Y Bord")
                break

    if array2d[0][0] == array2d[1][1] and array2d[0][0] == array2d[2][2] and array2d[0][0] != "-":
        if array2d[0][0] == 'x':
            print("X Bord")
        else:
            print("Y Bord")

    if array2d[0][2] == array2d[1][1] and array2d[0][2] == array2d[2][0] and array2d[0][2] != "-":
        if array2d[0][2] == 'x':
            print("X Bord")
        else:
            print("Y Bord")


show()
turn = 'x'
while True:
    print("Enter Location")
    a = int(input())
    b = int(input())

    if array2d[a][b] == "-":
        array2d[a][b] = turn
    show()
    win()

    if turn == 'x':
        turn = 'y'
    else:
        turn = 'x'
    # turn = 'x' if turn == 'y' else 'y'



