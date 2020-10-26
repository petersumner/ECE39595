package Exam;

public class Duble {
    private double value;
    public Duble(double g){
        value = g;
    }
    public void setValue(double g){
        value = g;
    }   
    public double getValue(){
        return value;
    }
    public String toString(){
        return ""+value;
    }
}
