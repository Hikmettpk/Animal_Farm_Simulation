//Hikmet Topak 150121047
//This class extends from Mammal. 
//This class holds some properties needed for birds and prints the required methods


public class Pig extends Mammal{

    private static int count = 0;

    public Pig(String name, int age){ //Using super and call name-age. 
        super(name, age);
        setLegNumber(4);
        setNumberOfOffsprings(12);
        setPregnancyPerYear(2);
        count++;
    }

    public static void decrementCounter() {
    }

    @Override
    public void sayGreetings() { //Override sayGreetinggs method and print chicken's words
        System.out.println("All animals are equal, but some animals are more equal than others!");
    }

    public static int getCount(){ //getter for count 
        return count;
    }

    public void decrementCount(){
        count--;
    }


}