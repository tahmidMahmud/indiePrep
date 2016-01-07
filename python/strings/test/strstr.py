import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.strstr import strstr

class Test(unittest.TestCase):

	def test_canary(self):
		
		self.assertTrue(True)

	def test_NeedleNotFound(self):
		testString = strstr("name@email.com", '?')

		self.assertEqual(testString, None)

	def test_HaystackIsNone(self):
		testString = strstr(None, '?')

		self.assertEqual(testString, None)

	def test_findOneCharNeedleInHaystack(self):
		testString = strstr("name@email.com", '@')

		self.assertEqual(testString, '@email.com')

	def test_findMultipleCharNeedleInHaystack(self):
		testString = strstr("name@email.com", '@em')

		self.assertEqual(testString, '@email.com')

	def test_BeforeNeedleEqualsTrue(self):
		testString = strstr("name@email.com", '@em', True)

		self.assertEqual(testString, 'name')

if __name__ == '__main__':
	unittest.main()