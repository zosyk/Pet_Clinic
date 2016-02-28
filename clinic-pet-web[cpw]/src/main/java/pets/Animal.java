package pets;

/**
 * Created by Alekcandr on 2/27/2016.
 */
public class Animal implements Pet {
    private String name;
    private String owner;
    private String age;
   public Animal(String name, String owner, String age){
       this.name = name;
       this.owner = owner;
       this.age = age;
   }
    public String getName(){
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public String getAge(){
        return age;
    }

}
