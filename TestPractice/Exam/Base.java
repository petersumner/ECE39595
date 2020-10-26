package Exam;

public class Base {
    public int i = 0;
    public Base() {
        System.out.println("B");
    }
    public Base(int i) {
        System.out.println("Bi");
    }
    public void m0() {
        System.out.println("Bm0");
    }
    public void m1() {
        System.out.println("Bm1");
    }
    public void m2() {
        System.out.println("Bm2");
        m4();
    }
    public void m3(){
        System.out.println("Bm3");
        m5();
    }
    private void m4(){
        System.out.println("Bm4");
    }
    private void m5(){
        System.out.println("Bm5");
    }
}
