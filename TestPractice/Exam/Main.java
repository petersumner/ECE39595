package Exam;

public class Main{
    private void fooD(double g){
        g = 2*g;
    }
    private void fooDuble(Duble d, boolean change){
        d.setValue(-d.getValue());
        if(change) d = new Duble(3);
    }
    public static void main(String[] args){
        Main m = new Main();
        Duble dd = new Duble(1.);
        Double d = 2.;

        m.fooD(d);
        System.out.println("d: "+d);
        m.fooDuble(dd, false);
        System.out.println("dd: "+dd);
        m.fooDuble(dd, true);
        System.out.println("dd: "+dd);
    }
}


/*
public class Main {
    public static void main(String[] args){
        Base b = new Base();
        b.m0();
        b.m2();
        //b.m4();
        //b.m5();

        Derived d = new Derived(1);
        d.m0();
        d.m1();
        d.m2();
        d.m3();
        //d.m4();
        //d.m5();
        d.m6();

        b = d;
        b.m0();
        b.m1();
        b.m2();
        b.m3();
        //b.m4();
        //b.m5();
        //b.m6();

        b = d;
        System.out.println(b.i);
        //System.out.println(b.j);
        System.out.println(d.i);
    }
    
}
*/