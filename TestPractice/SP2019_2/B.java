package SP2019_2;

public class B {
    public void f1(int i){
        System.out.println("B::f1(i)");
    }
    public void f1(double f){
        System.out.println("B::f1(f)");
    }
    public void f2( ){
        System.out.println("B::f2");
    }
    public void f5(B b){
        b.f3( );
    }
    private void f3( ){
        System.out.println("B::f3");
    }
}
