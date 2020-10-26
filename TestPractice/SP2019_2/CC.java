package SP2019_2;

public class CC implements Cloneable{
    public AA myA;
    public CC(AA a){ myA = a; }
    public Object clone() throws CloneNotSupportedException{
        CC c = (CC) super.clone();
        c.myA = new AA(myA.val);
        return c;
    }
}
