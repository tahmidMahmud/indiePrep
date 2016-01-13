import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.explode import explode

class Test(unittest.TestCase):

	def test_canary(self):

		self.assertTrue(True)

	def test_ExplodeNoneItems(self):
		test = explode(' ', None)
		
		self.assertEqual(test, [None])

	def test_ExplodeItemsWithNoneDelimiter(self):
		test = explode(None,'1,2,3')

		self.assertEqual(test, ['1,2,3'])

	def test_Explode2Items(self):
		test = explode(' ', '1 2')
		
		self.assertEqual(test, ['1', '2'])

	def test_Explode3Items(self):
		test = explode(' ', '1 2 3')
		
		self.assertEqual(test, ['1', '2', '3'])
	
	def test_Explode3ItemsSeperatedByComma(self):
		test = explode(',', '1,2,3')
		
		self.assertEqual(test, ['1', '2', '3'])

	def test_Explode3LimitedBy2(self):
		test = explode(',', '1,2,3', 2)
		
		self.assertEqual(test, ['1', '2,3'])

	def test_Explode4LimitedBy2(self):
		test = explode(',', '1,2,3,4', 2)
		
		self.assertEqual(test, ['1', '2,3,4'])

	def test_Explode4LimitedBy3(self):
		test = explode(',', '1,2,3,4', 3)
		
		self.assertEqual(test, ['1', '2', '3,4'])
	
	def test_Explode4LimitedBy1(self):
		test = explode(',', '1,2,3,4', 1)
		
		self.assertEqual(test, ['1,2,3,4'])
	
	def test_Explode4LimitedBy0(self):
		test = explode(',', '1,2,3,4', 0)
		
		self.assertEqual(test, ['1,2,3,4'])

	def test_Explode4LimitedByNegative1(self):
		test = explode(',', '1,2,3,4', -1)
		
		self.assertEqual(test, ['1', '2', '3'])

	def test_Explode4LimitedByNegative2(self):
		test = explode(',', '1,2,3,4', -2)
		
		self.assertEqual(test, ['1', '2'])

if __name__ == '__main__':
	unittest.main()