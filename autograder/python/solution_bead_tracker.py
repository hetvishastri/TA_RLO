from solution_blob_finder import SolutionBlobFinder
import sys

sys.path.insert(1, '/Users/hetvihirenshastri/Desktop/Documents/UMass/my_courses/TA/autograder/python/py_libraries')
import stdio
from picture import Picture

import os

""" Takes an integer min_pixels, a float Tau, a float Delta, and a sequence of JPG
filenames as command-line arguments; identifies the Beads in each JPG
image using BlobFinder; and writes out (one per line, formatted with 4
decimal places to the right of decimal point) the radial distance that
each bead moves from one frame to the next (assuming it is no more than
Delta). """

"""
we have to add jpg files one by one in order to show output.
"""
def solutiontrackBeads(P, tau, delta, bf,image):
    #P = int(sys.argv[1])
    #tau = float(sys.argv[2])
    #delta = float(sys.argv[3])
    #bf = BlobFinder(Picture(sys.argv[4]), tau)
    prevBeads = bf.getBeads(P)

    list=[]
    for i in range(len(image)):
        bf = SolutionBlobFinder(Picture(image[i]), tau)
        currBeads = bf.getBeads(P)
        for currBead in currBeads:
            min_dist = float('inf')
            for prevBead in prevBeads:
                d = currBead.distanceTo(prevBead)
                if d <= delta and d < min_dist:
                    min_dist = d
            if min_dist != float('inf'):
                list.append(round(min_dist,4))
        prevBeads = currBeads
    return list
        

if __name__ == '__main__':
    main()

#python bead_tracker.py 25 180.0 25.0 run_1/frame00001.jpg  run_1/frame00002.jpg
