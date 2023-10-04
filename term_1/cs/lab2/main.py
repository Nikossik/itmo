def output(array):
    result = ""
    for i in array:
        result += str(i)
    return result


msg = input('Код: ')
bits = []

for i in msg:
    bits.append(int(i))

s1 = bits[0] ^ bits[2] ^ bits[4] ^ bits[6]
s2 = bits[1] ^ bits[2] ^ bits[5] ^ bits[6]
s3 = bits[3] ^ bits[4] ^ bits[5] ^ bits[6]

print('Синдром: ', s1, s2, s3)

if (s1, s2, s3) == (0, 0, 0):
    print('Ошибок нет', output(bits))
elif (s1, s2, s3) == (0, 0, 1):
    bits[3] = (bits[3] + 1) % 2
    print('Ошибка в r3.\nОшибочный бит - 4', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (0, 1, 0):
    bits[1] = (bits[1] + 1) % 2
    print('Ошибка в r2.\nОшибочный бит - 2', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (0, 1, 1):
    bits[5] = (bits[5] + 1) % 2
    print('Ошибка в i3.\nОшибочный бит - 6', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (1, 0, 0):
    bits[0] = (bits[0] + 1) % 2
    print('Ошибка в r1.\nОшибочный бит - 1', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (1, 0, 1):
    bits[4] = (bits[4] + 1) % 2
    print('Ошибка в i2.\nОшибочный бит - 5', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (1, 1, 0):
    bits[2] = (bits[2] + 1) % 2
    print('Ошибка в i1.\nОшибочный бит - 3', '\nИсправленная последовательность: ', output(bits))
elif (s1, s2, s3) == (1, 1, 1):
    bits[6] = (bits[6] + 1) % 2
    print('Ошибка в i4.\nОшибочный бит - 7', '\nИсправленная последовательность: ', output(bits))
