import sys
import os

parent = os.path.abspath('./python')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")

from blob import Blob
import stdarray, luminance
from picture import Picture
import stdio


class BlobFinder:
    """
    A data type for identifying blobs in a picture.
    """

    def __init__(self, pic, tau):
        """
        Constructs a blob finder to find blobs in the picture pic, using
        a luminance threshold tau.
        """
        
        self._blobs = []
        """        
        # Enumerate the pixels of pic, and for each pixel (i, j):
        # 1. Create a Blob object called blob.
        # 2. Call _findBlob() with the right arguments.
        # 3. Add blob to _blobs if it has a non-zero mass.
        """
        
        """
        Write code here
        """    
        
    def _findBlob(self, pic, tau, i, j, marked, blob):
        """
        Identifies a blob using depth-first search. The parameters are
        the picture (pic), luminance threshold (tau), pixel column (i),
        pixel row (j), 2D boolean matrix (marked), and the blob being
        identified (blob).
        """

        """
        Write code here
        """
        
        
    def getBeads(self, P):
        """
        Returns a list of all beads with >= P pixels.
        """

        Blob = []

        """
        Write code here
        """
        
        return Blob

