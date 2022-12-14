import sys
import os
import stdio

from picture import Picture
from blob_finder import BlobFinder

parent = os.path.abspath('./python')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")


""" Takes an integer min_pixels, a float Tau, a float Delta, and a sequence of JPG
filenames as command-line arguments; identifies the Beads in each JPG
image using BlobFinder; and returns a list (formatted with 4
decimal places to the right of decimal point) the radial distance that
each bead moves from one frame to the next (assuming it is no more than
Delta). We have to add jpg files one by one in order to show output.
"""

def trackBeads(P, tau, delta, bf, images):

    disp = []

    """
    Write code here
    """
    
    return disp
        

