package com.gradescope.avogadro;
import com.gradescope.avogadro.Picture;
import com.gradescope.avogadro.BlobList;
import com.gradescope.avogadro.Luminance;
import com.gradescope.avogadro.Blob;

public class SolutionBlobFinder {
    private Picture img;
    private double tau;
    private BlobList bList = new BlobList();
    private boolean[][] bThere;

    public SolutionBlobFinder(Picture picture, double tau){

        img = picture;
        this.tau = tau;

        bThere = new boolean[img.width()][img.height()];

        for(int i = 0; i < img.width(); i++){
            for(int k = 0; k < img.height(); k++){
                bThere[i][k] = false; 
            }
        }
	
        findBlobs();
    }
    
    private void findBlobs(){

        for(int x = 0; x < img.width(); x++){
            for(int y = 0; y < img.height(); y++){

                if(Luminance.lum(img.get(x,y)) >= tau){
                   bList.newBlob();
                   dfs(x, y);
                }
                bThere[x][y] = true;
            }
        }       
    }
    
    private void dfs(int i, int j){

	if(i < 0 || j < 0 || i >= img.width() || j >= img.height() || bThere[i][j]) return;

        if(Luminance.lum(img.get(i,j)) < tau){
            bThere[i][j] = true;
            return;
        }
	
        bThere[i][j] = true;
        bList.addPoints(i, j);

        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }
    
    public int countBeads(int P){
        Blob [] tmp = bList.arrayOfBlobs(P);
        return tmp.length;
    }
    
    public Blob[] getBeads(int P){
        Blob [] tmp = bList.arrayOfBlobs(P);
        return tmp;
    }
}
