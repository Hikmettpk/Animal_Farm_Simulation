//Hikmet Topak 150121047
//In this class we keep critical data such as the names and ages of the animals. We keep them with getter and setter methods



public class Animal {
	
	private String name; //Keeping variables
    private int legNumber;
    private int age;
    private int pregnancyPerYear;
    private int numberOfOffsprings;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }


    public void sayGreeting(){ //Print sayGreeting
        System.out.println("Have nothing to say!");
    }

    public void reproduce(){ //Print reproduce
        System.out.println("None of your business!!");
    }

    public String toString() { //Creating a toString method
        return "My name is " + name + "!\n" +
                "I am " + age + " years old!\n" +
                "I have " + legNumber + " legs!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegNumber() {
        return legNumber;
    }

    public void setLegNumber(int legNumber) {
        this.legNumber = legNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPregnancyPerYear() {
        return pregnancyPerYear;
    }

    public void setPregnancyPerYear(int pregnancyPerYear) {
        this.pregnancyPerYear = pregnancyPerYear;
    }

    public int getNumberOfOffsprings() {
        return numberOfOffsprings;
    }

    public void setNumberOfOffsprings(int numberOfOffsprings) {
        this.numberOfOffsprings = numberOfOffsprings;
    }

}
