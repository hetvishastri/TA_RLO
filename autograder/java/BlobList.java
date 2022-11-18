// Name        : Tyler Fricks
// Email       : tyler.fricks@gmail.com
// Description :

public class BlobList {
    private Node first = null;
    public class Node{
        private Blob blob;
        private Node next;
    }
    // Create a list of blobs.
    public BlobList(){

    }
    // Add a blob to the list
    public void newBlob(){
        if(first == null){
            first = new Node();
            first.blob = new Blob();
        }else{
            Node current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node();
            current.next.blob = new Blob();;
        }   
    }
    //returns the size
    public int size(){
        int size = 0;
        Node current = first;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    private int size(int P){
        int size = 0;
        Node current = first;
        while(current != null){
            if(current.blob.mass() >= P)
                size++;
            current = current.next;
        }
        return size;
    }
    public Blob[] arrayOfBlobs(int P){
        Blob[] blobs = new Blob[size(P)];
        Node current = first;
        int i = 0;
        while(current != null){
            if(current.blob.mass() >= P){
                blobs[i] = current.blob;
                i++;
            }
            current = current.next;
        }
        return blobs;
    }
    public void addPoints(int x, int y){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        current.blob.add(x, y);
    }
}
