public class LongList implements MyList{
    public long data;
    public LongList n;

    public LongList(LongList n, long data){
        this.data = data;
        this.n = n;
    }

    public long getData(){
        return this.data;
    }

    public LongList next(){
        return this.n;
    }

    public void printNode(){
        System.out.print("LongList node, data is: " + this.getData());
    }
}