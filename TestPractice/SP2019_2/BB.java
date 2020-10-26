package SP2019_2;

public class BB implements Cloneable{
    public AA myA;
    public BB(AA a){ myA = a; }
    public Object clone() throws CloneNotSupportedException{
        return (BB) super.clone();
    }
}
