import math
import sys
sys.path.insert(1, '/Users/hetvihirenshastri/Desktop/Documents/UMass/my_courses/TA/autograder/python/py_libraries')
import stdio

""" Reads in the displacements produced by beadtracker.py from standard
input; computes an estimate of Boltzmann's constant and Avogadro's number;
and writes those estimates to standard output. """

"""
whe have to add jpg one by one inorder to print output or get dsplacment files of text files
"""
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
    #stdio.writef('Boltzman = %e\nAvogadro = %e\n', k, N_A)

if __name__ == '__main__':
    main()

#  python bead_tracker.py 25 180.0 25.0  run_1/frame00000.jpg run_1/frame00001.jpg | python avogadro.py
