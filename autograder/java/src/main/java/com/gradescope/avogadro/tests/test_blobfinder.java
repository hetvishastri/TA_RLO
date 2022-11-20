
package com.gradescope.avogadro.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.gradescope.jh61b.grader.GradedTest;

import com.gradescope.avogadro.Picture;

import com.gradescope.avogadro.BlobFinder;
import com.gradescope.avogadro.SolutionBlobFinder;

import com.gradescope.avogadro.Blob;

import java.util.*;

public class test_blobfinder {
    int P = 0;
    double tau = 180.0;
    Picture picture = new Picture("./run_1/frame00000.jpg");

    BlobFinder finder = new BlobFinder(picture, tau);
    SolutionBlobFinder solfinder = new SolutionBlobFinder(picture, tau);


    public void test_beads_length(){
        int beads = finder.countBeads(P);


        int solbeads = solfinder.countBeads(P);
        assertEquals(beads,solbeads);
        
    }

    public void test_blob_length(){

        int blobs = finder.countBeads(1);

        int solblobs = solfinder.countBeads(1);

        assertEquals(blobs,solblobs);
        
    }

    public void test_beads(){

        Blob [] tmp = finder.getBeads(P);
        List<Blob> bead = new ArrayList<>();
        for(int i = 0; i < tmp.length; i++)
        bead.add(tmp[i]);

        Blob [] soltmp = solfinder.getBeads(P);
        List<Blob> solbead = new ArrayList<>();
        for(int i = 0; i < soltmp.length; i++)
        solbead.add(soltmp[i]);

        assertEquals(bead,solbead);
        
    }

    public void test_blob(){

        Blob [] tmp = finder.getBeads(1);
        List<Blob> blob = new ArrayList<>();
        for(int i = 0; i < tmp.length; i++)
        blob.add(tmp[i]);

        Blob [] soltmp = solfinder.getBeads(1);
        List<Blob> solblob = new ArrayList<>();
        for(int i = 0; i < soltmp.length; i++)
        solblob.add(soltmp[i]);

        assertEquals(blob,solblob);
        
    }

}

