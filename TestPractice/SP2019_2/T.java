package SP2019_2;

public class T implements Runnable{
    public static Object obj = new Object();
    
    public synchronized void f1(A a){
        a.x++;
    }
    public void f2(A a){
        synchronized(obj){
            a.y++;
        }
    }
    public void f3(A a){
        synchronized(a){
            a.z++;
        }
    }
    public synchronized void run(){
        f1(Main.a);
        f2(Main.a);
        f2(Main.a);
    }
}
