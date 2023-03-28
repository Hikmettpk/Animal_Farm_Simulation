//Hikmet Topak 150121047
//This class extends from Bird. 
//This class holds some properties needed for birds and prints the required methods

public class Chicken extends Bird{

    private static int count;

    public Chicken(String name, int age) { //Using super and call name-age. 
        super(name, age);
        setLegNumber(2);
        setNumberOfOffsprings(1);
        setPregnancyPerYear(200);
        count++;
    }

    @Override
    public void sayGreetings() { //Override sayGreetinggs method and print chicken's words
        System.out.println("I have nothing to say other than I am against Pigs!");
    }

    public static void decrementCounter() {
    }


    public static int getCount() { //getter for count 
        return count;
    }

    public static void decrementCount() {
        count--;
    }

}