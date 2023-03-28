//Hikmet Topak 150121047
/*
 This program is an animal farm simulation. 
 You can add and remove animals to the animal farm within the options. 
 You can sort these animals and find the number of animals for the next year. 
 Finally, you can write them to a file
 */

import java.util.*;
public class Text {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean bool = true;
        System.out.println("Welcome to Animal Farm simulation program! " +
                "\nPlease enter the capacity: ");
        int capacity = scan.nextInt();

        AnimalFarm animalFarm = new AnimalFarm(capacity); //Creating an object from AnimalFarm class

        while (bool) {                                         //Main while loop
            System.out.println("0 - Exit the program " +
                    "\n1 - Add animal " +
                    "\n2 - Remove animal " +
                    "\n3 - Search animal " +
                    "\n4 - Sort animals " +
                    "\n5 - Calculate next year's population estimate " +
                    "\n6 - Print all animal's movements " +
                    "\n7 - Print all animals's eating habits " +
                    "\n8 - Print report " +
                    "\nPlease enter your choice: ");

            int usersNumber = scan.nextInt();

            switch (usersNumber){ //A switch case that operates according to the user's option
                case 0: //The program stops if the user presses 0
                    bool = false;
                    break;
                case 1: 
                    System.out.println("1 - Chicken " + //Request animal type if the user selects 1
                            "\n2 - Donkey " +
                            "\n3 - Horse " +
                            "\n4 - Pig " +
                            "\n5 - Raven " +
                            "\n6 - Sheep " +
                            "\nSelect animal type: ");
                    int usersAnimalType = scan.nextInt(); 

                    System.out.println("Enter the name: ");
                    String userAnimalName = scan.next(); //Taking animal's name from user

                    System.out.println("Enter the age: "); //Taking animal's age from user
                    int userAnimalAge = scan.nextInt();

                    switch (usersAnimalType) { //Create an object of that type according to the type of animal entered and call the add method of the animalFarm class
                        case 1 :               //Return an error message if the given name already exists
                            try {
                                Chicken chicken = new Chicken(userAnimalName,userAnimalAge); //
                                animalFarm.addAnimal(chicken);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2 :
                            try {
                                Donkey donkey = new Donkey(userAnimalName,userAnimalAge);
                                animalFarm.addAnimal(donkey);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3 :
                            try {
                                Horse horse = new Horse(userAnimalName,userAnimalAge);
                                animalFarm.addAnimal(horse);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4 :
                            try {
                                Pig pig = new Pig(userAnimalName,userAnimalAge);
                                animalFarm.addAnimal(pig);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 5 :
                            try {
                                Raven raven = new Raven(userAnimalName,userAnimalAge);
                                animalFarm.addAnimal(raven);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6 :
                            try {
                                Sheep sheep = new Sheep(userAnimalName,userAnimalAge);
                                animalFarm.addAnimal(sheep);
                            }catch (IllegalNameException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                case 2 : //Remove an animal from the list according to the name received from the user
                    System.out.println("Which animal do you want to remove");
                    String userAnimalName2 = scan.next();
                    System.out.println(userAnimalName2 + " removed.");
                    boolean removed = animalFarm.removeAnimal(userAnimalName2);
                    break;
                
                case 3 : //Search an animal from the list according to the name received from user
                    System.out.println("1 - Search base on name " +
                            "\n2 - Search base on age");
                    int userchoice = scan.nextInt();
                    switch (userchoice) {
                        case 1 : //If the user choose name section, call searchBaserdOnName method
                            System.out.println("Enter name: ");
                            String searchedName = scan.next();

                            animalFarm.searchBasedOnName(searchedName);

                            break;
                        case 2 : //If the user choose age section, call searchBasedOnAge method
                            System.out.println("Enter age: ");
                            int searchedAge = scan.nextInt();

                            animalFarm.searchBasedOnAge(searchedAge);
                            break;
                    }
                    break;
                
                case 4 : //sorting animals according to user's choice 
                    System.out.println("1 - Sort based on name " +
                            "\n2 - Sort based on leg number " +
                            "\n3 - Sort based on age " +
                            "\n4 - Sort based on addition date");
                    int userSortChoice = scan.nextInt();

                    switch (userSortChoice) {
                        case 1: //If user choose 1, call sortAlphabetically method and sort
                            animalFarm.sortAlphabetically();
                            break;
                        case 2: ////If user choose 2, call sortBasedOnLegNumber method and sort
                            animalFarm.sortBasedOnLegNumber();
                            break;
                        case 3: //If user choose 3, call sortBasedOnAge method and sort
                            animalFarm.sortBasedOnAge();
                            break;
                        case 4: //If user choose 4, call printAllAnimals method and sort
                            animalFarm.printAllAnimals();
                            break;
                    }
                    break;
                
                case 5 : //Call nextYearPopulationForecast method and Calculate next year population of listed animals
                    System.out.println(animalFarm.nextYearPopulationForecast());
                    break;
                
                case 6 : //Call animalMovements method and print animals movements
                    animalFarm.animalMovements();
                    break;
                
                case 7 : //Call eatingHabits method and print animals eating habits
                    animalFarm.eatingHabits();
                    break;
                
                case 8 : //Call printReport method and print everything to a file
                	System.out.println("Enter a file name : ");
                	String fileName = scan.next();
                	animalFarm.printReport(fileName);
                    break;

            }
        }

    }
}