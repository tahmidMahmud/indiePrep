import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.explode import explode

class Test(unittest.TestCase):

	def test_canary(self):

		self.assertTrue(True)

	def test_Explode2Items(self):
		test = explode(' ', '1 2')
		
		self.assertEqual(test, ['1', '2'])

	def test_Explode3Items(self):
		test = explode(' ', '1 2 3')
		
		self.assertEqual(test, ['1', '2', '3'])


if __name__ == '__main__':
	unittest.main()