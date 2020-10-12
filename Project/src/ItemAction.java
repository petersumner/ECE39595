package src;

public class ItemAction extends Action {
    
    public ItemAction(Item owner){}

    public void setName(String name){
        System.out.println("   name: " + name);
    }

    public void setType(String type){
        System.out.println("   type: " + type);
    }
}
