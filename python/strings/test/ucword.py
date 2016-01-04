import sys
import os
import unittest
sys.path.insert(0,os.path.abspath(__file__+"/../.."))
from src.ucword import ucword

class Test(unittest.TestCase):
	
	def test_canary(self):
		self.assertTrue(True)

	def test_OneWord(self):
		self.assertEqual(ucword('hello'), 'Hello')

	def test_TwoWords(self):
		self.assertEqual(ucword('hello goodbye'), 'Hello Goodbye')

	def test_TwoWordsTwoSpace(self):
		self.assertEqual(ucword('hello  goodbye'), 'Hello  Goodbye')

	def test_WithDelimiter(self):
		self.assertEqual(ucword('hello|goodbye', '|'), 'Hello|Goodbye')

if __name__ == '__main__':
	unittest.main()