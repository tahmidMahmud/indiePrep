def strstr(haystack, needle, before_needle = False):
	if haystack == None:
		return None
	else:
		for i in range(len(haystack)):
			if haystack[i: i+len(needle)] == needle:
				if before_needle == True:
					return haystack[:i]
				else:
					return haystack[i:]
				