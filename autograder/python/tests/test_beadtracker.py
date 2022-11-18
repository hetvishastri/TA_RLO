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


class TestBead(unittest.TestCase):
    def setUp(self):
        self.P = 0
        self.tau = 180.0
        self.delta=25.0

        self.bf = BlobFinder(Picture('../dataset/run_1/frame00001.jpg'), self.tau)
        self.sb = SolutionBlobFinder(Picture('../dataset/run_1/frame00001.jpg'), self.tau)
        self.prevBeads = self.bf.getBeads(self.P)
        self.prevBeads_sol = self.bf.getBeads(self.P)

#     @weight(1)
#     @number("1.1")
    def test_beads(self):
        image=['../dataset/run_1/frame00002.jpg']
        def trackbead(Blobfinder,prevBeads):
            list=[]
            for i in range(len(image)):
                bf = BlobFinder(Picture(image[i]), self.tau)
                currBeads = bf.getBeads(self.P)
                for currBead in currBeads:
                    min_dist = float('inf')
                    for prevBead in prevBeads:
                        d = currBead.distanceTo(prevBead)
                        if d <= self.delta and d < min_dist:
                            min_dist = d
                    if min_dist != float('inf'):
                        list.append(round(min_dist,4))
                prevBeads = currBeads
            return list

        list=trackbead(BlobFinder,self.prevBeads)
        sol_list=trackbead(SolutionBlobFinder,self.prevBeads_sol)
        self.assertListEqual(list,sol_list)




## Test cases
# P=12, tay=100
# P=50 tau=200
