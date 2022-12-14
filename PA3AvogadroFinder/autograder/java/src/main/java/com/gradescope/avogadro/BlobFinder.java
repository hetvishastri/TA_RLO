package com.gradescope.avogadro;

import com.gradescope.avogadro.Picture;
import com.gradescope.avogadro.BlobList;
import com.gradescope.avogadro.Luminance;
import com.gradescope.avogadro.Blob;

// API for the class BlobFinder
// The class defines funtions that help find the blobs
// in a given picture.
public class BlobFinder {

    private Picture img;
    private double tau;
    private BlobList bList = new BlobList();
    private boolean[][] bThere;

    public BlobFinder(Picture picture, double tau){
    }

    // Finds all the blobs in the image
    private void findBlobs(){
    }

    // Computes the dfs that starts at the pixel located at i,j 
    private void dfs(int i, int j){
    }

    // Counts the number of beads in picture
    public int countBeads(int P){
    }

    // Returns a list of beads in picture
    public Blob[] getBeads(int P){
    }
}
