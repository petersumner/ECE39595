package src;

public class CreatureAction extends Action {

    public String name;
    public String type;
    
    public CreatureAction(Creature owner){
        System.out.println("CreatureAction:");
    }

    public void setName(String _name){
        name = _name;
        System.out.println("   name: " + name);
    }

    public void setType(String _type){
        type = _type;
        System.out.println("   type: " + type);
    }
}
