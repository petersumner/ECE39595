package src;

public class ItemAction extends Action {

    public Item owner;
    public String name;
    public String type;
    
    public ItemAction(Item _owner){
        owner = _owner;
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
