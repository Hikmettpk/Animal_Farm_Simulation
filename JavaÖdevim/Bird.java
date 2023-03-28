//Hikmet Topak 150121047
//This class extends from Animal
//This class contains the necessary methods and holds

public abstract class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }

    public void fly(){ //fly Method
        System.out.println("I can fly to the endless skies!");
    }

    @Override
    public void reproduce(){ //reproduce method
        System.out.println("I lay eggs!");
    }

    public void omnivore(){ //omnivore method
        System.out.println("I can eat everything!");
    }

    public abstract void sayGreetings();
}