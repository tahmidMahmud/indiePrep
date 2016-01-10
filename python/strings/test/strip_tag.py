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

	def test_StringAllowableTags(self):
		tagless = strip_tags('<p>hello</p>', '<p>')

		self.assertEqual(tagless, '<p>hello</p>')

	def test_twoStringAllowOneTags(self):
		tagless = strip_tags('<p>hello</p><a>Goodbye</a>', '<p>')

		self.assertEqual(tagless, '<p>hello</p>Goodbye')

	def test_twoStringAllowOtherTags(self):
		tagless = strip_tags('<p>hello</p><a>Goodbye</a>', '<a>')

		self.assertEqual(tagless, 'hello<a>Goodbye</a>')

	def test_Allow2tagsBlock1tag(self):
		tagless = strip_tags('<p>hello</p><a>Goodbye</a><c>Goodbye</c>', '<p><a>')

		self.assertEqual(tagless, '<p>hello</p><a>Goodbye</a>Goodbye')


if __name__ == '__main__':
	unittest.main()

