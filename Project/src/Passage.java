package src;

public class Passage extends Structure {

    public String name;
    public int room1;
    public int room2;
    public int[] xArr = new int[100];
    public int[] yArr = new int[100];
    public int idx = 0;
    
    public Passage(){
        System.out.println("Passage:");
    }

    public void setName(String _name){
        name = _name;
        System.out.println("   name: " + name);
    }

    public void setId(int _room1, int _room2){
        room1 = _room1;
        room2 = _room2;
        System.out.println("   room1: " + room1 + "\n   room2: " + room2);
    }

    public void setPosX(int x){
        xArr[idx] = x;
        System.out.println("   posX: " + x);
    }

    public void setPosY(int y){
        yArr[idx++] = y;
        System.out.println("   posY: " + y);
    }
}
