package src;

public class Displayable {

    public int maxHit;
    public int hpMoves;
    public int hp;
    public char type;
    public int intValue;
    public int posX;
    public int posY;
    public int width;
    public int height;
    public boolean visible = true;
    
    public Displayable(){}

    public void setInvisible(){
        visible = false;
        System.out.println("   invisible");
    }

    public void setMaxHit(int _maxHit){
        maxHit = _maxHit;
        System.out.println("   maxHit: " + _maxHit);
    }

    public void setHpMove(int _hpMoves){
        hpMoves = _hpMoves;
        System.out.println("   hpMoves: " + hpMoves);
    }

    public void setHp(int _hp){
        hp = _hp;
        System.out.println("   hp: " + hp);
    }

    public void setType(char t){
        type = t;
        System.out.println("   type: " + type);
    }

    public void setIntValue(int v){
        intValue = v;
        System.out.println("   intValue: " + intValue);
    }

    public void setPosX(int x){
        posX = x;
        System.out.println("   posX: " + x);
    }

    public void setPosY(int y){
        posY = y;
        System.out.println("   posY: " + y);
    }

    public void setWidth(int x){
        width = x;
        System.out.println("   width: " + x);
    }

    public void setHeight(int y){
        height = y;
        System.out.println("   height: " + y);
    }
}
