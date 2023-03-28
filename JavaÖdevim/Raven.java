//Hikmet Topak 150121047
//This class extends from Bird. 
//This class holds some properties needed for birds and prints the required methods


public class Raven extends Bird{

    private static int count = 0;

    public Raven(String name, int age){ //Using super and call name-age. 
        super(name,age);
        setLegNumber(2);
        setNumberOfOffsprings(5);
        setPregnancyPerYear(1);
        count++;
    }

    public static void decrementCounter() {
    }

    @Override
    public void sayGreetings() { //Override sayGreetinggs method and print chicken's words
        System.out.println("A happy country where we poor animals shall rest forever!");
    }

    public static int getCount(){ //getter for count 
        return count;
    }

    public void decrementCount(){
        count--;
    }
}
