def substr_replace(str, replacment, start, length = None):
	if str == None:
		return replacment
	elif replacment == None:
		return str
	else:
		if length == None:
			length = len(str)
		elif length == 0:
			length = start
		str = str[:start] + replacment + str[length:]
		return str