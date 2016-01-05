def trim(str, characterMask = ' '):
	letters = list(str)
	maskList = list(characterMask)
	i = 0
	while maskList.count(letters[i]) > 0:
		i = i + 1
	j = len(letters) - 1 
	while maskList.count(letters[j]) > 0:
		j = j - 1
	letters = letters[i:j+1]
	str = ''.join(letters)
	return str