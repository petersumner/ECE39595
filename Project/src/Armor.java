package src;

public class Armor extends Item {
    
    public String name;

    public Armor(String _name){
        name = _name;
        System.out.println("Armor: " + name);
    }

    public void setName(String _name){
        name = _name;
        System.out.println("Armor name set to " + name);
    }
}
