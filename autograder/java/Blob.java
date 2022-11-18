// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :

public class Blob {
    private int ySum = 0;
    private int xSum = 0;
    private int mass = 0;
    
    public Blob(){
    };
    public void add (int i, int j){
        xSum+=i;
        ySum+=j;
        mass++;
    }
    public int mass(){
        return mass;
    }
    public double distanceTo(Blob b){
        double othercx = b.xCoord();
        double othercy = b.yCoord();
        double cx = xCoord();
        double cy = yCoord(); 
        return Math.sqrt(Math.pow((othercx - cx), 2) + Math.pow(othercy - cy, 2));
    }
    public String toString(){
        return String.format("%2d (%8.4f, %8.4f)", mass, xCoord(), yCoord());
    }
    public static void main(String[] args) {
        Blob b = new Blob();
        b.add(4,3);
        b.add(3,3);
        b.add(3,6);
        Blob t = new Blob();
        t.add(8,4);
        t.add(0,3);
        t.add(23,2);
        System.out.println(b.distanceTo(t));
        System.out.println(b);
    }
    private double xCoord(){
        double xSum = this.xSum;
        double mass = this.mass;
        return xSum/mass;
    }
    private double yCoord(){
        double ySum = this.ySum;
        double mass = this.mass;
        return ySum/mass;
    }

}
