
package com.gradescope.avogadro.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.gradescope.jh61b.grader.GradedTest;

import com.gradescope.avogadro.Picture;

import com.gradescope.avogadro.BlobFinder;
import com.gradescope.avogadro.SolutionBlobFinder;



public class test_blobfinder {
    int P = 0;
    double tau = 180.0;
    Picture picture = new Picture("./run_1/frame00000.jpg");

    BlobFinder finder = new BlobFinder(picture, tau);
    SolutionBlobFinder solfinder = new SolutionBlobFinder(picture, tau);


    public void test_beads_length(){
        int beads = finder.countBeads(P);
        int blobs = finder.countBeads(1);

        int beads = solfinder.countBeads(P);
        int blobs = solfinder.countBeads(1);

    }


    
    System.out.println(beads + " Beads:");
    Blob [] tmp = finder.getBeads(P);

    for(int i = 0; i < tmp.length; i++)
    System.out.println(tmp[i]);
    System.out.println("");
    System.out.println(blobs + " Blobs:");
    Blob [] e = finder.getBeads(1);
    for(int i = 0; i < e.length; i++)
    System.out.println(e[i]);
    
}

