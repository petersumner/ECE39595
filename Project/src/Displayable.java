package src;

public class Displayable {
    
    public Displayable(){}

    public void setInvisible(){
        System.out.println("   invisible");
    }

    public void setMaxHit(int maxHit){
        System.out.println("   maxHit: " + maxHit);
    }

    public void setHpMove(int hpMoves){
        System.out.println("   hpMoves: " + hpMoves);
    }

    public void setHp(int Hp){
        System.out.println("   hp: " + Hp);
    }

    public void setType(char t){
        System.out.println("   type: " + t);
    }

    public void setIntValue(int v){
        System.out.println("   intValue: " + v);
    }

    public void setPosX(int x){
        System.out.println("   posX: " + x);
    }

    public void setPosY(int y){
        System.out.println("   posY: " + y);
    }

    public void setWidth(int x){
        System.out.println("   width: " + x);
    }

    public void setHeight(int y){
        System.out.println("   height: " + y);
    }
}
