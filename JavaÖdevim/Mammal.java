//Hikmet Topak 150121047
//This class extends from Animal
//This class contains the necessary methods and holds


public abstract class Mammal extends Animal{

    Mammal(String name, int age){
        super(name,age);
    }

    public void walk(){ //walk method
        System.out.println("I can walk to the far away lands!");
    }

    @Override
    public void reproduce() { //reproduce method
        System.out.println("I give birth!");
    }

    public void herbivore(){ //herbivore method
        System.out.println("I eat plants only!");
    }


    public abstract void sayGreetings();
}