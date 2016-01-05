def wordwrap(str, width = 75, _break = "\n", cut = False):
	if len(str) < width:
		return str
	else:
		cutIndex = width
		for i in range(len(str)//width):
                        if cut == False:
                                while str[cutIndex] != ' ':
                                        cutIndex = cutIndex - 1
                                str = str[:cutIndex] + _break + str[cutIndex+1:]
                        else:
                                str = str[:cutIndex] + _break + str[cutIndex:]
                        cutIndex = cutIndex + width + len(_break) 
		return str

                


