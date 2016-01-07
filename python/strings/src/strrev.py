def strrev(string):
	if string == None:
		return string
	else:
		return ''.join(string[-i] for i in range(1, len(string)+1))
	