package SP2019_2;

public class DD {
    public AA myA;
    public DD(AA a){ myA = a; }
    public DD(DD d) {
        myA = new AA(d.myA.val);
    }
}
