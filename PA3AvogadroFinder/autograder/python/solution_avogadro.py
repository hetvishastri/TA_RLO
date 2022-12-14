import stdio
import math
import sys
import os

parent = os.path.abspath('./python')
sys.path.insert(1, parent)
sys.path.insert(1, parent + "/py_libraries/")

""" Reads in the displacements produced by beadtracker.py from standard
input; computes an estimate of Boltzmann's constant and Avogadro's number;
and writes those estimates to standard output. """

"""
whe have to add jpg one by one inorder to print output or get dsplacment files of text files
"""

def solutionfindAvogadroConstant(displacements):
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
