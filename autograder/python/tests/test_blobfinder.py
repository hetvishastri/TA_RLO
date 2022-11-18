import unittest
import os, sys

parent = os.path.abspath('.')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")

from blob import Blob
from blob_finder import *

from solution_blob import SolutionBlob
from solution_blob_finder import *

from picture import Picture
import stdarray, luminance
import stdio


class TestBlobs(unittest.TestCase):
    def setUp(self):
        self.P = 0
        self.tau = 180.0
        self.pic = Picture('../dataset/run_1/frame00000.jpg')
        self.b = BlobFinder(self.pic, self.tau)
        self.sb = SolutionBlobFinder(self.pic, self.tau)
        self.beads1 = self.b.getBeads(self.P)
        self.beads2 = self.sb.getBeads(self.P)   

#     @weight(1)
#     @number("1.1")
    def test_beads_length(self):
        #checking number of beads
        self.assertEqual(len(self.beads1),len(self.beads2))

#     @weight(1)
#     @number("1.2")
    def test_beads_values(self):
        stdio.writeln(str(len(self.beads1)) + ' Beads:')
        list=[]
        for i in self.beads1:
            list.append(str(i))
        solution_list=[]
        count=0
        for i in self.beads2:
            solution_list.append(str(i))
        self.assertListEqual(solution_list,list)



## Test cases
# P=12, tay=100
# P=50 tau=200

