def wordwrap(str, width = 75, _break = "\n", cut = False):
	if len(str) < width:
		return str
	else:
		
			cutIndex = width
			for i in range(len(str)//width):
				str = str[:cutIndex] + _break + str[cutIndex:]
				cutIndex = cutIndex + width + len(_break) 
			return str



