def strip_tags(string, allowable_tags = None):
	if string != None:

		lengthOfStr = len(string)
		
		def symbolFinder (n, str): return lambda x: str[x] == n
		lessThanSymbol = list(filter(symbolFinder('<', string), range(lengthOfStr)))
		greaterThanSymbol = list(filter(symbolFinder('>', string), range(lengthOfStr)))
		
		numberOfTags = len(lessThanSymbol)
		tags = [string[lessThanSymbol[i]:greaterThanSymbol[i]+1] for i in range(numberOfTags)]

		if allowable_tags != None:

			lengthOfAllowableString = len(allowable_tags)
			allowable_lessThanSymbol = list(filter(symbolFinder('<', allowable_tags), range(lengthOfAllowableString)))
			allowable_greaterThanSymbol = list(filter(symbolFinder('>', allowable_tags), range(lengthOfAllowableString)))
		
			numberOfAllowableTags = len(allowable_lessThanSymbol)
			AllowableTags = [string[allowable_lessThanSymbol[i]:allowable_greaterThanSymbol[i]+1] for i in range(numberOfAllowableTags)]

			def allowedTagFilter (n): return lambda x: tags[x] == n
		
		if numberOfTags > 0:
			return ''.join(string[greaterThanSymbol[i]+1:lessThanSymbol[i+1]] for i in range(numberOfTags-1))
	
	return string
