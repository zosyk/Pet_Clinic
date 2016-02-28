package pets;

/**
 * Created by Alekcandr on 2/27/2016.
 */
public class Dog implements Pet   {
    private Animal animal;
    public Dog(Animal animal){
        this.animal=animal;
    }


    public String getName() {
      return   animal.getName();
    }

    public String getOwner() {
        return animal.getOwner();
    }

    public String getAge() {
        return animal.getAge();
    }
    public String toString(){
        return "<strong>Name:</strong> "+getName()+" <strong>Owner:</strong> "+getOwner()+" <strong>Age:</strong>"+getAge();
    }
}
