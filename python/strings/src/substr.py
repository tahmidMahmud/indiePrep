def substr(str, startIndex, length = None):
	if str == None or len(str) < abs(startIndex):
		return False
	if length == None:
		lastIndex = len(str)
	elif length < 0:
		lastIndex = len(str) + length
	else:
		lastIndex = startIndex + length
	return str[startIndex:lastIndex]