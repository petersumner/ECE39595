public class IntList implements MyList {
    public int data;
    public IntList n;

    public IntList(IntList n, int data){
        this.data = data;
        this.n = n;
    }

    public int getData(){
        return this.data;
    }

    public IntList next(){
        return this.n;
    }

    public void printNode(){
        System.out.print("IntList Node, data is: " + this.getData());
    }
}