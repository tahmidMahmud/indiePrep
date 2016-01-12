def explode(delimiter, string, limit = None):
	if delimiter != None and string != None:
		delimiterIndexes = list(filter(lambda x: string[x] == delimiter, (i for i in range(len(string)))))
		explodedList = list()
		explodedList.append(string[:delimiterIndexes[0]])
		if limit == None or len(delimiterIndexes)+1 <= limit:
			for i in range(len(delimiterIndexes)-1):
				explodedList.append(string[delimiterIndexes[i]+1:delimiterIndexes[i+1]])
			explodedList.append(string[delimiterIndexes[-1]+1:])
		else:
			for i in range(limit-2):
				explodedList.append(string[delimiterIndexes[i]+1:delimiterIndexes[i+1]])
			explodedList.append(string[delimiterIndexes[limit-2]+1:])
		return explodedList
	else:
		return string
