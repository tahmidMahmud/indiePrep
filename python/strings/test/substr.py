import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__+"/../.."))
from src.substr import substr

class Test(unittest.TestCase):

	def test_canary(self):
	
		self.assertTrue(True)

	def test_SubstrWithPositiveStartIndex(self):
		subString = substr("hello", 2)

		self.assertEqual(subString, "llo")

	def test_SubstrWithNegativeStartIndex(self):
		subString = substr("hello", -1)

		self.assertEqual(subString, "o")

	def test_SubstrLenthLessThanPositiveStartIndex(self):
		subString = substr("one", 3)

		self.assertFalse(subString)

	def test_SubstrLenthLessThanNegativeStartIndex(self):
		subString = substr("one", -4)

		self.assertFalse(subString)


	def test_SubstrWithNULLInput(self):
		subString = substr(None, -1)

		self.assertFalse(subString)

	def test_SubstrWithPositiveLength(self):
		subString = substr("abcdef", 3, 1)

		self.assertEqual(subString, 'd')

	def test_SubstrWithNegativeLength(self):
		subString = substr("abcdef", 2, -1)

		self.assertEqual(subString, 'cde')

	def test_SubstrWithANumberTooNegative(self):
		subString = substr("abcdef", 4, -4)

		self.assertFalse(subString)

	def test_SubstrWWithZeroLength(self):
		subString = substr("abcdef", 3, 0)

		self.assertFalse(subString)


if __name__ == '__main__':
	unittest.main()
