import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.strip_tags import strip_tags
 
class Test(unittest.TestCase):
	
	def test_canary(self):
		
		self.assertTrue(True)

	def test_StringWithNoTags(self):
		tagless = strip_tags('hello')

		self.assertEqual(tagless, 'hello')

	def test_StringInsideTags(self):
		tagless = strip_tags('<p>hello</p>')

		self.assertEqual(tagless, 'hello')

	def test_twoStringInsideTags(self):
		tagless = strip_tags('<p>hello</p><a>Goodbye</a>')

		self.assertEqual(tagless, 'helloGoodbye')



if __name__ == '__main__':
	unittest.main()

