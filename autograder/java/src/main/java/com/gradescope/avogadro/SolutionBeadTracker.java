// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :
package com.gradescope.avogadro;
import java.util.*;
import java.lang.Math;

public class SolutionBeadTracker {
    public List<Double> SolutionBeadTrack(int P, double tau, double delta, String[] image) {
        // int P = Integer.parseInt(args[0]);
        // double tau = Double.parseDouble(args[1]);
        // double delta = Double.parseDouble(args[2]);
        Picture img1;
        Picture img2;
        List<Double> disp = new ArrayList<>();
        //System.out.println(args.length);
        for(int i = 0; i < image.length-1; i++){
            img1 = new Picture(image[i]);
            img2 = new Picture(image[i+1]);
            SolutionBlobFinder scan = new SolutionBlobFinder(img1, tau);
            SolutionBlobFinder scan2 = new SolutionBlobFinder(img2, tau);
            Blob [] scanBlob = scan.getBeads(P);
            Blob [] scan2Blob = scan2.getBeads(P);
            for(int k = 0; k < scan2Blob.length; k++){
                double least = 0;
                boolean first = true;
                for(int j = 0; j < scanBlob.length; j++){
                    double distance = scan2Blob[k].distanceTo(scanBlob[j]);
                    if(distance <= delta && first){
                        least = distance;
                        first = false;
                    }else if(distance <= delta && distance < least){
                        least = distance;
                    }
                }
                if(least > 0)
                    disp.add((double)Math.round(least * 10000d) / 10000d);
                    //disp.add(Math.round(least));
                    System.out.printf("%.4f\n", least);
            }
        }
        return disp;

    }
}
