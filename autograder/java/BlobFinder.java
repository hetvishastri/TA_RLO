// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :

public class BlobFinder {
    private Picture img;
    private double tau;
    private BlobList bList = new BlobList();
    private boolean[][] bThere;
    public BlobFinder(Picture picture, double tau){
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
    public static void main(String[] args) {
        int P = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture picture = new Picture(args[2]);
        BlobFinder finder = new BlobFinder(picture, tau);
        int beads = finder.countBeads(P);
        int blobs = finder.countBeads(1);
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
}