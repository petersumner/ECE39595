package Exam;

public class Derived extends Base{
    public int i = 1;
    public int j = 1;

    public Derived(){
        super(1);
        System.out.println("D");
    }

    public Derived(int i){
        System.out.println("Di");
    }

    public void m1(){
        System.out.println("Dm1");
    }

    public void m3(){
        System.out.println("Dm3");
        m5();
    }
    private void m5(){
        System.out.println("Dm5");
    }
    public void m6(){
        System.out.println("Dm6");
    }
}
