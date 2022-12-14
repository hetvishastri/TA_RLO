package com.gradescope.avogadro.tests;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.avogadro.Picture;
import com.gradescope.avogadro.BlobFinder;
import com.gradescope.avogadro.SolutionBlobFinder;
import com.gradescope.avogadro.Blob;


public class test_blobfinder {
    int P = 25;
    double tau = 180.0;
    Picture picture = new Picture("./frame00000.jpg");

    BlobFinder finder = new BlobFinder(picture, tau);
    SolutionBlobFinder solfinder = new SolutionBlobFinder(picture, tau);

    @Test
    @GradedTest(name="Test creating for number of beads from varargs", max_score=1)
    public void test_beads_length(){

        int beads = finder.countBeads(P);
        int solbeads = solfinder.countBeads(P);

        assertEquals(beads,solbeads);
        
    }

    @Test
    @GradedTest(name="Test creating for number of blobs from varargs", max_score=1)
    public void test_blob_length(){

        int blobs = finder.countBeads(1);
        int solblobs = solfinder.countBeads(1);

        assertEquals(blobs,solblobs);
        
    }

    @Test
    @GradedTest(name="Test creating for value of beads from varargs", max_score=1)
    public void test_beads(){

        Blob [] tmp = finder.getBeads(P);
        String [] bead= new String[tmp.length];

        for(int i = 0; i < tmp.length; i++){
	    Arrays.fill(bead, tmp[i].toString());
	}

        Blob [] tmp1 = solfinder.getBeads(P);
        String [] solbead= new String[tmp1.length];
	
        for(int i = 0; i < tmp1.length; i++){
	    Arrays.fill(solbead, tmp[i].toString());
	}

        assertArrayEquals(bead,solbead);
        
    }

    @Test
    @GradedTest(name="Test creating for value of blobs from varargs", max_score=1)
    public void test_blob(){

        Blob [] tmp = finder.getBeads(1);
        String [] blob= new String[tmp.length];

        for(int i = 0; i < tmp.length; i++){
	    Arrays.fill(blob, tmp[i].toString());
	}
	    
        Blob [] tmp1 = solfinder.getBeads(1);
        String [] solblob= new String[tmp1.length];

        for(int i = 0; i < tmp1.length; i++){
	    Arrays.fill(solblob, tmp[i].toString());
	}
	
        assertArrayEquals(blob,solblob);
        
    }

}

