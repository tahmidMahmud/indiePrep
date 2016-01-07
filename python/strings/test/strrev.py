import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.strrev import strrev

class Test(unittest.TestCase):
	
	def test_canary(self):
		
		self.assertTrue(True)

	def test_reverseString(self):
		reverse = strrev('hello')
		
		self.assertEqual(reverse, 'olleh')

	def test_NoneString(self):
		reverse = strrev(None)
		
		self.assertEqual(reverse, None)

if __name__ == '__main__':
	unittest.main()
		