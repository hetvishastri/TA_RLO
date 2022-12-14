package com.gradescope.avogadro;
import java.util.*;

public class SolutionAvogadro {
    public List<Double> FindAvogadro(double [] rArray) {

        double P = 0.5e-6;
        double R = 8.31457;
        double N = 9.135e-4;
        double PIXELS_TO_METERS = 0.175e-6;

        double dSum = 0;
        int count = 0;
        int T = 297;
        double D = 0;

	for(int i = 0; i < rArray.length; i++){
            dSum+=Math.pow(rArray[i]*PIXELS_TO_METERS, 2);
            count++;
        }
	
        D = dSum/(2*count);

	List<Double> sol = new ArrayList<>();
	
        double boltzmann = (6*Math.PI*D*N*P)/T;
        sol.add(boltzmann);
	
	double avogadro = R/boltzmann;
        sol.add(avogadro);
	
        return sol;
        
    }
}
