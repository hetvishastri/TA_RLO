import unittest
import os, sys
from gradescope_utils.autograder_utils.decorators import weight, visibility, number

parent = os.path.abspath('./python')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")

from blob import Blob
from blob_finder import *

from solution_blob import SolutionBlob
from solution_blob_finder import *
from bead_tracker import *
from solution_bead_tracker import * 

from picture import Picture
import stdarray, luminance
import stdio


class TestBead(unittest.TestCase):
    def setUp(self):
        self.P = 0
        self.tau = 180.0
        self.delta=25.0

        self.bf = BlobFinder(Picture('./dataset/run_1/frame00001.jpg'), self.tau)
        self.sb = SolutionBlobFinder(Picture('./dataset/run_1/frame00001.jpg'), self.tau)
        self.prevBeads = self.bf.getBeads(self.P)
        self.prevBeads_sol = self.bf.getBeads(self.P)

    @weight(1)
    @number("1.1")
    def test_beads(self):

        image = ['./dataset/run_1/frame00002.jpg']
        list = trackBeads(self.P, self.tau, self.delta, self.bf, image)
        sol_list = solutiontrackBeads(self.P, self.tau, self.delta, self.sb, image)

        self.assertListEqual(list, sol_list)



