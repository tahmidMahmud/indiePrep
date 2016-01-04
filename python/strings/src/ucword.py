def ucword(str, delimiter = ' '):
	letterList = list(str)
	letterList[0] = letterList[0].upper()
	for i in range(len(letterList)):
		if letterList[i] == delimiter or (delimiter == ' ' and (letterList[i] == '\t' or letterList[i] == '\r' or letterList[i] == '\n' or letterList[i] == '\f' or letterList[i] == '\v')):
			letterList[i + 1] = letterList[i + 1].upper()
	str = "".join(letterList)
	return str
	