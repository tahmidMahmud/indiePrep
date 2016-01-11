def explode(delimiter, string, limit = None):
	if delimiter != None and string != None:
		delimiterIndexes = list(filter(lambda x: string[x] == delimiter, (i for i in range(len(string)))))
		explodedList = list()
		explodedList.append(string[:delimiterIndexes[0]])
		for i in range(len(delimiterIndexes)-1):
			explodedList.append(string[delimiterIndexes[i]+1:delimiterIndexes[i+1]])
		explodedList.append(string[delimiterIndexes[-1]+1:])
		print(explodedList)
		return explodedList
	else:
		return string
