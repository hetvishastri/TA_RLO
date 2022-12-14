package com.gradescope.avogadro.tests;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.avogadro.Picture;
import com.gradescope.avogadro.BlobFinder;
import com.gradescope.avogadro.SolutionBlobFinder;
import com.gradescope.avogadro.BeadTracker;
import com.gradescope.avogadro.SolutionBeadTracker;
import com.gradescope.avogadro.Blob;


public class test_beadtracker {
    int P = 25;
    double tau = 180.0;
    double delta=25.0;

    BeadTracker beadtrack= new BeadTracker();
    SolutionBeadTracker solbeadtrack = new SolutionBeadTracker();

    @Test
    @GradedTest(name="Test creating for number of displacements from varargs", max_score=1)
    public void test_beads_length(){

        String[] image = {"./frame00000.jpg","./frame00001.jpg"};
        
        List<Double> disp_list = beadtrack.BeadTrack(P, tau, delta, image);
        
        List<Double> sol_disp_list = solbeadtrack.SolutionBeadTrack(P, tau, delta, image);
        assertEquals(disp_list, sol_disp_list);
        
    }

}
