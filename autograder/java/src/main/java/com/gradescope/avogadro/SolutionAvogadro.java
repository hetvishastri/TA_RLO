package com.gradescope.avogadro;
// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :
import java.util.*;

public class SolutionAvogadro {
    public List<Double> SolutionFindAvogadro(double [] rArray) {
        double P = 0.5e-6;
        double R = 8.31457;
        double N = 9.135e-4;
        double PIXELS_TO_METERS = 0.175e-6;
        //double [] rArray = StdIn.readDoubles();
        List<Double> sol = new ArrayList<>();
        double dSum = 0;
        int count = 0;
        int T = 297;
        double D = 0;
        for(int i = 0; i < rArray.length; i++){
            dSum+=Math.pow(rArray[i]*PIXELS_TO_METERS, 2);
            count++;
        }
        D = dSum/(2*count);
        double boltzmann = (6*Math.PI*D*N*P)/T;
        double avogadro = R/boltzmann;
        sol.add(boltzmann);
        sol.add(avogadro);
        System.out.printf("Boltzmann = %.4e\n", boltzmann);
        System.out.printf("Avogadro = %.4e\n", avogadro);
        return sol;
        
    }
}
