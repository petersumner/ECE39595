package SP2019_2;

public class Main {

    public static A a = new A();
    public static void main(String args[]) throws Exception {
        B b = new B( );
        D d = new D( );

        b.f5(b);
        d.f1(1);
        d.f1((long) 1);
        d.f1(1.0);
        d.f2();
        d.f4();
        b.f5(b);
        b = d;
        b.f1(1);
        b.f1((long) 1);
        b.f2();
        //b.f4();
        b.f5(b);

        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.run();
        t2.run();
        t1.start();
        t2.start();

        AA origA = new AA(10);
        BB origB = new BB(origA);
        CC origC = new CC(origA);
        DD origD = new DD(origA);

        BB newB = (BB) origB.clone();
        CC newC = (CC) origC.clone();
        DD newD = new DD(origD);

        origA.val = -100;
        System.out.println(newB.myA.val);
        System.out.println(newC.myA.val);
        System.out.println(newD.myA.val);
    }
}

