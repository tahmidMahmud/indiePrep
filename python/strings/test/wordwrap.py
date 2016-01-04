import sys
import os
import unittest
sys.path.insert(0,os.path.abspath(__file__+"/../.."))
from src.wordwrap import wordwrap

class Test(unittest.TestCase):
	
	def test_canary(self):
		self.assertTrue(True)

	def test_wordLengthLessThenCutWidth(self):
		self.assertEqual(wordwrap('hello'), 'hello')

	def test_wordWidth8BreakWithnewLine(self):
		word = wordwrap('hello goodbye', 8)
		x = word.find('\n')
		self.assertEqual(x, 6)

	def test_wordWidth8BreakWithDollarSymbol(self):
		word = wordwrap('hello goodbye', 8, '$')
		x = word.find('$')
		self.assertEqual(x, 6)

	def test_wordWidth8CutEqualToTrue(self):
		word = wordwrap('hello goodbye', 8, '\n', True)
		x = word.find('\n')
		self.assertEqual(x, 8)

if __name__ == '__main__':
	unittest.main()