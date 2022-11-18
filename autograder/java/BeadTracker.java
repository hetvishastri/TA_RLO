// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :

public class BeadTracker {
    public static void main(String[] args) {
        int P = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        Picture img1;
        Picture img2;
        //System.out.println(args.length);
        for(int i = 3; i < args.length-1; i++){
            img1 = new Picture(args[i]);
            img2 = new Picture(args[i+1]);
            BlobFinder scan = new BlobFinder(img1, tau);
            BlobFinder scan2 = new BlobFinder(img2, tau);
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
                    System.out.printf("%.4f\n", least);
            }
        }
    }
}
