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
import com.gradescope.avogadro.Avogadro;
import com.gradescope.avogadro.SolutionAvogadro;
import com.gradescope.avogadro.SolutionBlobFinder;
import com.gradescope.avogadro.Blob;


public class test_avogadro {
    int P = 25;
    double tau = 180.0;
    double delta = 25.0;

    String[] images = {"./frame00000.jpg","./frame00001.jpg"};

    BeadTracker beadTracker = new BeadTracker();
    SolutionBeadTracker solBeadTracker = new SolutionBeadTracker();    

    Avogadro avogadro = new Avogadro();
    SolutionAvogadro solAvogadro = new SolutionAvogadro();
    
    @Test
    @GradedTest(name="Compute Avogadro constant", max_score=1)
    public void test_avogadro(){

	List<Double> disp    = beadTracker.BeadTrack(P, tau, delta, images);
	List<Double> solDisp = solBeadTracker.SolutionBeadTrack(P, tau, delta, images);

	double[] disp_arr     = disp.stream().mapToDouble(Double::doubleValue).toArray();
	double[] sol_disp_arr = solDisp.stream().mapToDouble(Double::doubleValue).toArray();
	
	List<Double> avo = avogadro.FindAvogadro(disp_arr);
	List<Double> solAvo = solAvogadro.FindAvogadro(sol_disp_arr);

	assertEquals(avo, solAvo);	
    }
}



    
    
    

    


