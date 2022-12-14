import stdio
import math
import sys
import os

parent = os.path.abspath('./python')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")

""" Reads in the displacements produced by beadtracker.py
input; computes an estimate of Boltzmann's constant and Avogadro's number;
return k which is the Boltzmann's constant and N_A which is
the Avogadro's number
"""

def findAvogadroConstant(displacements):
    return k, N_A

