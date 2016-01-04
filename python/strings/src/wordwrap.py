def wordwrap(str, width = 75, _break = "\n", cut = False):
	if len(str) < width:
		return str
	else:
		if cut ==False:
			wordList = str.split()
			str = ''
			cutIndex = 0
			for word in wordList:
				if len(str[cutIndex:] + word) < width:
					str = str + word + " "
				else:
					str = str + _break + word + " "
					cutIndex = len(str)
			return str[:len(str)]
		else:
			cutIndex = width
			for i in range(len(str)//width):
				str = str[:cutIndex] + _break + str[cutIndex:]
				cutIndex = cutIndex + width + len(_break) 
			return str



