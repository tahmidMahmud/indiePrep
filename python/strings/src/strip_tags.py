def strip_tags(string, allowable_tags = None):
	if string != None:
		lessThanTags = list()
		greaterThanTags = list()
		for i in range(len(string)):
			if string[i] == '<':
				lessThanTags.append(i)
			if string[i] == '>':
				greaterThanTags.append(i)

		if len(lessThanTags) == len(greaterThanTags):
			if len(lessThanTags) == 0:
				return string
			else:
				str = ''.join(string[greaterThanTags[i]+1:lessThanTags[i+1]] for i in range(len(lessThanTags)-1))
				return str
	else:
		return None