package src;

public class CreatureAction extends Action {
    
    public CreatureAction(Creature owner){
        System.out.println("CreatureAction:");
    }

    public void setName(String _name){
        System.out.println("   name: " + _name);
    }

    public void setType(String _type){
        System.out.println("   type: " + _type);
    }
}
