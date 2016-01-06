import sys
import os
import unittest

sys.path.insert(0, os.path.abspath(__file__ + "/../.."))
from src.strtoupper import strtoupper

class Test(unittest.TestCase):

	def test_canary(self):
		
		self.assertTrue(True)

	def test_NoneString(self):
		string = strtoupper(None)
		
		self.assertEqual(string, None)

	def test_lowercasToUPPERCASE(self):
		string = strtoupper('hi')
		
		self.assertEqual(string, 'HI')

	def test_UPPERCASEtoUPPERCASE(self):
		string = strtoupper('HI')
		
		self.assertEqual(string, 'HI')

	def test_MiXeDCasetoUPPERCASE(self):
		string = strtoupper('Hi')
		
		self.assertEqual(string, 'HI')

	def test_NonAlphabeticaltoUPPERCASE(self):
		string = strtoupper('Hi{}|?!@#$%^')
		
		self.assertEqual(string, 'HI{}|?!@#$%^')



if __name__ == '__main__':
	unittest.main()