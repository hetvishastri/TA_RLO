import unittest
import os, sys
import math

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


class TestAvogadro(unittest.TestCase):
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
    def test_avogadra(self):
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

        def findAvogadroConstant(displacements):
            n = 0
            var = 0.00
            for a in displacements:
                a = a * (0.175 * (10 ** (-6)))
                var += a * a
                n += 1
            var = var / (2 * n)
            eta = 9.135 * 10 ** -4
            rho = 0.5 * 10 ** -6
            T = 297.0
            R = 8.31457
            k = 6 * math.pi * var * eta * rho / T
            N_A = R / k
            return k, N_A

        list=trackbead(BlobFinder,self.prevBeads)
        sol_list=trackbead(SolutionBlobFinder,self.prevBeads_sol)

        avogadro=findAvogadroConstant(list)
        sol_avogadro=findAvogadroConstant(sol_list)

        self.assertEqual(avogadro,sol_avogadro)




## Test cases
# P=12, tay=100
# P=50 tau=200
