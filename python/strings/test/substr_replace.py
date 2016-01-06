import sys
import os
import unittest
sys.path.insert(0, os.path.abspath(__file__+"/../.."))

from src.substr_replace import substr_replace

class Test(unittest.TestCase):

	def test_canary(self):

		self.assertTrue(True)

	def test_ReplaceStringZeroStartIndex(self):
		myString = substr_replace('abcdefgh', 'bill', 0)

		self.assertEqual(myString, 'bill')

	def test_ReplaceStringWithPositiveStartIndex(self):
		myString = substr_replace('abcdefgh', 'bill', 1)

		self.assertEqual(myString, 'abill')

	def test_ReplaceStringWithNegativeStartIndex(self):
		myString = substr_replace('abcdefgh', 'bill', -1)

		self.assertEqual(myString, 'abcdefgbill')

	def test_ReplaceNoneString(self):
		myString = substr_replace(None, 'bill', 0)

		self.assertEqual(myString, 'bill')

	def test_ReplaceStringWithNoneString(self):
		myString = substr_replace('abcdefgh', None, 0)

		self.assertEqual(myString, 'abcdefgh')

	def test_ReplaceStringWithPositiveLength(self):
		myString = substr_replace('abcdefgh', 'bill', 0, 4)

		self.assertEqual(myString, 'billefgh')

	def test_ReplaceStringWithZeroLength(self):
		myString = substr_replace('abcdefgh', 'bill', 2, 0)

		self.assertEqual(myString, 'abbillcdefgh')

	def test_ReplaceStringWithNegativeLength(self):
		myString = substr_replace('abcdefgh', 'bill', 2, -2)

		self.assertEqual(myString, 'abbillgh')



if __name__ == '__main__':
	unittest.main()