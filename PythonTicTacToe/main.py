def binary_search(l, key):
    first = 0
    end = len(l) - 1
    while first <= end:
        middle = (first + end) // 2
        if l[middle] < key:
            first = middle + 1
        elif l[middle] > key:
            end = middle - 1
        else:
            return middle
    return -1




li = [1, 2, 4, 5]
result = binary_search(li, 2)

if result == -1:
    print("Not Found")
else:
    print("Found" + str(result))