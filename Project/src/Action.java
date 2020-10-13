package src;

public class Action {

    public String msg;
    public int v;
    public char c;
    
    public void setMessage(String _msg){
        msg = _msg;
        System.out.println("   actionMessage: " + msg);
    }

    public void setIntValue(int _v){
        v = _v;
        System.out.println("   intValue: " + v);
    }

    public void setCharValue(char _c){
        c = _c;
        System.out.println("   charValue: " + c);
    }
}
