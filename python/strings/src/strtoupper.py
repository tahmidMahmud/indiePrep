def strtoupper(str):
	if str != None:
		asciiValues = [ord(char) for char in str]
		for i in range(len(asciiValues)):
			if asciiValues[i] >= ord('a') and asciiValues[i] <= ord('z'):
				asciiValues[i] = asciiValues[i] - 32
		
		return ''.join(chr(value) for value in asciiValues)
	else:
		return str		 
