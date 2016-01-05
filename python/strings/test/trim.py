import sys
import os
import unittest 

sys.path.insert(0,os.path.abspath(__file__+"/../.."))
from src.trim import trim

class Test(unittest.TestCase):

	def test_canary(self):
		self.assertTrue(True)

	def test_trimWhiteSpace(self):
		self.assertEqual(trim('      hello'), 'hello')

	def test_trimCharacterMask(self):
		self.assertEqual(trim('Hello World', 'Hdle'), 'o Wor')

if __name__ == '__main__':
	unittest.main()