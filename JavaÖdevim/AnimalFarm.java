//Hikmet Topak 150121047
//This class holds the necessary variables.
//This class contains methods for animalFarm such as add, remove, sort and print report


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AnimalFarm {

    private ArrayList<Animal> animalList; //Creating array Lists
    private ArrayList<String> animalNames;
    private final int CAPACITY;
    private int numberOfAnimals;


    public AnimalFarm(int capacity) {
        this.animalList = new ArrayList<>();
        this.animalNames = new ArrayList<>();
        this.CAPACITY = capacity;
        numberOfAnimals = 0;
    }

    public int getNumberOfAnimals() {
        return numberOfAnimals;
    }



    public boolean addAnimal(Animal animal) throws IllegalNameException { //Adding the animals entered by the user to the Array List and returning an error message if there is an animal to be added
        if (numberOfAnimals >= CAPACITY) {
            return false;
        }
        String name = animal.getName();
        if (animalNames.contains(name)) {
            throw new IllegalNameException("Animal with name " + name + " already exists in the farm.");
        }
        animalList.add(animal);
        animalNames.add(name);
        numberOfAnimals++;
        return true;
    }

   
    public boolean removeAnimal(String name) { //If there is an animal entered by the user from Array List, it removes it from the list. 
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i); //Creating animal object
            if (animal.getName().equals(name)) {
                animalList.remove(i);
                animalNames.remove(name);
                numberOfAnimals--;
                if (animal instanceof Chicken) { //Subtracting the number from the class to which the animal belongs
                    Chicken.decrementCounter();
                } else if (animal instanceof Donkey) {
                    Donkey.decrementCounter();
                } else if (animal instanceof Horse) {
                    Horse.decrementCounter();
                } else if (animal instanceof Pig) {
                    Pig.decrementCounter();
                } else if (animal instanceof Raven) {
                    Raven.decrementCounter();
                } else if (animal instanceof Sheep) {
                    Sheep.decrementCounter();
                }
                return true;
            }
        }
        return false;
    }

    public void printAllAnimalGreeting() { //Printing all animals' greeting
        for (int i = 0; i < animalList.size(); i++) {
            printOneAnimalGreeting(animalList.get(i));
        }

    }

    public void printOneAnimalGreeting(Animal animal) { //Print one animal's greeting
        animalList.get(animalList.indexOf(animal)).sayGreeting();
    }

    public void printAllAnimalNames() { //Print all animals' names
        for (int i = 0; i < animalNames.size(); i++) {
            printOneAnimalName(animalList.get(i));
        }
    }

    public void printOneAnimalName(Animal animal) { //Print one animal's name
        System.out.println(animalList.get(animalList.indexOf(animal)).getName());
    }

    public void printAllAnimals() { //Print all animals
        System.out.println(animalNames.toString());
    }

    public int nextYearPopulationForecast() {//Calculating next year population using animals' number of off spring and pregnancy per year
        int offSping = 0;
        
        for (int i = 0; i < animalList.size(); i++) {
            offSping += animalList.get(i).getNumberOfOffsprings() * animalList.get(i).getPregnancyPerYear();
        }

        int totalNumber = animalList.size() + offSping;
        
        return totalNumber;

    }

    public void animalMovements() { //Printing animals' movements using fly and walk methods
        for (Animal animal : animalList) {
            if (animal instanceof Bird) {
                ((Bird) animal).fly();
            } else if (animal instanceof Mammal) {
                ((Mammal) animal).walk();
            }
        }
    }

    public void eatingHabits() { //Printing animals' movements using omnivore and herbivore methods
        for (Animal animal : animalList) {
            if (animal instanceof Bird) {
                ((Bird) animal).omnivore();
            } else if (animal instanceof Mammal) {
                ((Mammal) animal).herbivore();
            }
        }
    }

    public void sortAlphabetically() { // Sorting animals alphabetically. 
        ArrayList<Animal> sortedList = new ArrayList<>(animalList); //Create a new array to keep the original list unchanged

        Collections.sort(sortedList, new Comparator<Animal>() { //Compare animals' names
            public int compare(Animal animal1, Animal animal2) {
                return animal1.getName().compareTo(animal2.getName());
            }
        });

        for (Animal animal : sortedList) {
            System.out.println(animal.getName());
        }
    }

    public void sortBasedOnLegNumber() { // Sorting animals according to their leg numbers

        ArrayList<Animal> sortedList = new ArrayList<>(animalList); //Create a new array to keep the original list unchanged


        Collections.sort(sortedList, new Comparator<Animal>() { //Compare animals' leg number
            public int compare(Animal animal1, Animal animal2) {
                return Integer.compare(animal1.getLegNumber(), animal2.getLegNumber());
            }
        });


        for (Animal animal : sortedList) {
            System.out.println(animal.getName() + " - " + animal.getLegNumber() + " legs");
        }
    }

    public void sortBasedOnAge() { // Sorting animals according to their ages

        ArrayList<Animal> sortedList = new ArrayList<>(animalList); //Create a new array to keep the original list unchanged



       Collections.sort(sortedList, new Comparator<Animal>() { //Compare animals' ages
            public int compare(Animal animal1, Animal animal2) {
                return Integer.compare(animal1.getAge(), animal2.getAge());
            }
        });

        for (Animal animal : sortedList) {
            System.out.println(animal.getName() + " - " + animal.getAge() + " years old");
        }
    }

    public void searchBasedOnName(String name) { //Searching animals' according to their names
        boolean found = false;
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.println(animal.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Animal with name " + name + " not found.");
        }
    }


    public void searchBasedOnAge(int age) { //Searching animals' according to their ages
        boolean found = false;
        for (Animal animal : animalList) {
            if (animal.getAge() == age) {
                System.out.println(animal.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animals found with age " + age + ".");
        }
    }

    public void printReport(String fileName)  { //Printing all stuff to a report. 
    	try {
            File file = new File(fileName); //Creating object
            PrintWriter outputForFile = new PrintWriter(file);
            outputForFile.println("We have a total of " + numberOfAnimals + " animals in the farm.\n");

            if (Chicken.getCount() > 0 && Chicken.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Chicken.getCount() + " of them are Chicken. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Chicken) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            if (Donkey.getCount() > 0 && Donkey.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Donkey.getCount() + " of them are Donkey. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Donkey) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            if (Horse.getCount() > 0 && Horse.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Horse.getCount() + " of them are Horse. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Horse) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            if (Pig.getCount() > 0 && Pig.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Pig.getCount() + " of them are Pig. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Pig) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            if (Sheep.getCount() > 0 && Sheep.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Sheep.getCount() + " of them are Sheep. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Sheep) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            if (Raven.getCount() > 0 && Raven.getCount() <= CAPACITY) {//Checking some conditions
                outputForFile.println("* " + Raven.getCount() + " of them are Pig. Those are:");
                outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", "Name", "Age", "Leg Number");

                for (int i = 0; i < animalList.size(); i++) {
                    if (animalList.get(i) instanceof Raven) {
                        outputForFile.printf("%16s%-16s%-16s%-16s%n"," ", animalList.get(i).getName(), animalList.get(i).getAge(), animalList.get(i).getLegNumber());
                        outputForFile.println();
                    }
                }
            }
            outputForFile.close(); //Closing file
            
            String message = "Successfully saved to file: " + fileName; //Message

            System.out.println(message);
        }
        catch(IOException e) {//If the report does not work
            System.out.println("Error to file : " + e.getMessage());
        }

    }



}
