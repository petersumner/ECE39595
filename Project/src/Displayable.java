package src;

public class Displayable {
    
    public Displayable(){
        
    }

    public void setInvisible(){
        System.out.println("Invisible");
    }

    public void setMaxHit(int maxHit){
        System.out.println("Max Hit = " + maxHit);
    }

    public void setHpMove(int hpMoves){
        System.out.println("HP Moves = " + hpMoves);
    }

    public void setHp(int Hp){
        System.out.println("HP = " + Hp);
    }

    public void setType(char t){
        System.out.println("Type = " + t);
    }

    public void setIntValue(int v){
        System.out.println("Int Value = " + v);
    }

    public void setPosX(int x){
        System.out.println("Pos X = " + x);
    }

    public void setPosY(int y){
        System.out.println("Pos Y = " + y);
    }

    public void setWidth(int x){
        System.out.println("Width = " + x);
    }

    public void setHeight(int y){
        System.out.println("Height = " + y);
    }
}
