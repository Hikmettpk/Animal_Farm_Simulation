//Hikmet Topak 150121047
//This class extends from Mammal. 
//This class holds some properties needed for birds and prints the required methods


public class Sheep extends Mammal{

    private static int count = 0;

    public Sheep(String name, int age){ //Using super and call name-age. 
        super(name, age);
        setLegNumber(4);
        setNumberOfOffsprings(1);
        setPregnancyPerYear(1);
        count++;
    }

    public static void decrementCounter() {
    }

    @Override
    public void sayGreetings() { //Override sayGreetinggs method and print chicken's words
        System.out.println("Four legs good, two legs better!");
    }

    public static int getCount(){ //getter for count 
        return count;
    }

    public static void decrementCount(){
        count--;
    }


}