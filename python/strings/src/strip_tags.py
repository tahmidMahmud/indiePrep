def strip_tags(string, allowable_tags = None):
	allowableTags = list()
	if allowable_tags != None:
		i = 0
		while i < len(allowable_tags):
			if allowable_tags[i] == '>':
				allowable_tags = allowable_tags[:i+1] + ' ' + allowable_tags[i+1:]
			i = i + 1
		allowableTags = allowable_tags.split(' ')
		for i in range(len(allowableTags)):
			allowableTags.append(allowableTags[i][:1]+'/'+allowableTags[i][1:])

	i = 0
	start = -1
	while i < len(string):
		if string[i] == '<':
			j = i + 1
			while j < len(string):
				if string[j] == '>':
					if allowable_tags!= None and string[i:j+1] in allowableTags:
						start = j
						i = start
					else:
						string = string[:i] + string[j+1:]
						i = start
					j = len(string)
				j = j + 1
		i= i + 1
	return string