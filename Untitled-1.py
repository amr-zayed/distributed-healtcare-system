def StringChallenge(strParam):
    numbers = {'zero': 0,
    'one': 1, 
    'two': 2, 
    'three': 3,
    'four': 4, 
    'five': 5,
    'six': 6, 
    'seven': 7,
    'eight': 8,
    'nine': 9}

    numbersCheck = ['zero',
    'one', 
    'two', 
    'three',
    'four', 
    'five',
    'six', 
    'seven',
    'eight',
    'nine']

    operations = {'plus': True, 'minus': False}
    operationsCheck = ['plus', 'minus']
    done = True
    numlenStart = 0
    numlen = 3
    currentNum = 0
    decodedNums = []
    decodedOperation = []
    while done:
        if numlen> len(strParam):
            done = False
        if strParam[numlenStart:numlen] in numbersCheck:
            currentNum = currentNum*10 + numbers[strParam[numlenStart:numlen]]
            numlenStart = numlen
        elif strParam[numlenStart:numlen] in operationsCheck:
            decodedNums.append(currentNum)
            decodedNums.append(operations[strParam[numlenStart:numlen]])
            numlenStart = numlen
            currentNum = 0
        numlen+=1

    decodedNums.append(currentNum)
    number = decodedNums[0]
    for i in range(len(decodedNums)):

        if type(decodedNums[i]) is bool:
            if decodedNums[i]:
                number = number+decodedNums[i+1]
            else: 
                number = number-decodedNums[i+1]
    # code goes here
    return number

# keep this function call here 
print(StringChallenge(input()))