import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // Private array of monkey species avaiable for intake
    private static String[] speciesEligibleForTraining = { "Capuchin", "Guenon", "Macaque", "Marmoset",
            "Squirrel monkey", "Tamarin" };
    // Monkey array list
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Dog array list
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Used to keep track of when app should quit
    private static boolean quit = false;
    // New scanner instance for methods
    private static Scanner scnr = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        // Seeds dog arrayList
        initializeDogList();
        // Seeds monkey arrayList
        initializeMonkeyList();
        // Starts the main loop
        loop();
    }

    // Clearing console with using ANSI Escape Code
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Loop method
    public static void loop() {
        do {
            // Displays the primary menu
            displayMenu();
            String userInput = scnr.nextLine();
            if (userInput.equals("q")) {
                System.out.println("Quitting application");
                quit = true;
            } else if (userInput.equals("1")) {
                intakeNewDog(scnr);
            } else if (userInput.equals("2")) {
                intakeNewMonkey(scnr);
            } else if (userInput.equals("3")) {
                reserveAnimal(scnr);
            } else if (userInput.equals("4")) {
                printAnimals("dogs");
            } else if (userInput.equals("5")) {
                printAnimals("monkeys");
            } else if (userInput.equals("6")) {
                printAnimals("avaiable");
            } else {
                clearConsole();
                System.out.println("Invalid input! Please input 1,2,3,4,5,6 or q to quit");
                System.out.println("_____________________________________________________________");
            }
            // If user types q application will quit
        } while (quit != true);
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Buttons", "Monkey", "male", "3", "25.6", "05-12-2019", "United States", "intake",
                false, "United States", 3.5, 2.4, 5.8, "Capuchin");

        Monkey monkey2 = new Monkey("Tina", "Monkey", "female", "3", "25.6", "05-12-2019", "United States",
                "in service", false, "United States", 3.5, 2.4, 5.8, "Capuchin");
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    // Intake new dog with duplicate name validation
    public static void intakeNewDog(Scanner scanner) {
        // Clearing out the console
        clearConsole();

        // Gets dogs name with duplicate name validation
        String name;
        do {
            System.out.println("What is the dog's name?");
            name = scanner.nextLine();
        } while (name.isEmpty());
        // Checks that the new dog is not already in the arraylist
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu if dog already in system
            }
        }

        // Gets dogs breed with input validation
        String breed;
        do {
            System.out.println("What is the dog breed?");
            breed = scanner.nextLine();
        } while (breed.isEmpty());

        // Gets dogs gender with input validation
        String gender;
        do {
            System.out.println("What is the dog gender?");
            gender = scanner.nextLine();
        } while (gender.isEmpty());

        // Gets dogs age with input validation
        String age;
        do {
            System.out.println("What is the dog age?");
            age = scanner.nextLine();
        } while (age.isEmpty());

        // Gets dogs age with input validation
        String weight;
        do {
            System.out.println("What is the dog weight?");
            weight = scanner.nextLine();
        } while (weight.isEmpty());

        // Gets dogs date of acquisition with regex format validation
        String acquisitionDate;
        do {
            System.out.println("What is the dog acquisitionDate? Enter in YYYY-MM-DD format");
            acquisitionDate = scanner.nextLine();
        } while (!acquisitionDate.matches("\\d{4}-\\d{2}-\\d{2}"));

        // Gets country of dogs acquisition
        String acquisitionCountry;
        do {
            System.out.println("What is the dog acquisitionCountry?");
            acquisitionCountry = scanner.nextLine();
        } while (acquisitionCountry.isEmpty());

        // Gets dogs training status with format validation
        String trainingStatus;
        do {
            System.out.println("What is the dog trainingStatus? Enter in the following format: intake (or) in service");
            trainingStatus = scanner.nextLine();
        } while (!trainingStatus.equals("intake") && !trainingStatus.equals("in service"));

        // Dog reservation with true/false string validation
        String reserved;
        do {
            System.out.println("Is the dog reserved? Enter true or false.");
            reserved = scanner.nextLine();
        } while (!reserved.equals("false") && !reserved.equals("true"));

        // Gets dogs service country
        String inServiceCountry;
        do {
            System.out.println("What is the dog inServiceCountry?");
            inServiceCountry = scanner.nextLine();
        } while (inServiceCountry.isEmpty());

        // Instantiates new dog with user input variables
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                Boolean.valueOf(reserved), inServiceCountry);
        // Adds the new dog instance to the dog arraylist
        dogList.add(newDog);
        // Output to user
        System.out.println();
        System.out.println(name + " has been added to the dog list.");
        System.out.println("_____________________________________________________________");
        return; // Returns to menu
    }

    // Intake new monkey with duplicate name and species validation
    public static void intakeNewMonkey(Scanner scanner) {
        clearConsole();

        // Gets monkeys Name with input validation
        String name;
        do {
            System.out.println("What is the monkeys's name?");
            name = scanner.nextLine();
        } while (name.isEmpty());

        // Checks if new monkey name is already in the arraylist
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Gets monkeys species with input validation
        String species;
        do {
            System.out.println("What is the monkey species?");
            species = scnr.nextLine();
        } while (species.isEmpty());

        // Check if the incoming monkey is on the aproved list
        Boolean speciesMatched = false;
        for (String s : speciesEligibleForTraining) {
            if (s.equalsIgnoreCase(species)) {
                // System.out.println("\n\nWe are currently not accepting this species of
                // monkey.\n\n");
                speciesMatched = true;
            }
        }
        if (!speciesMatched) {
            System.out.println("\n\nWe are currently not accepting this species of monkey.\n\n");
            return;
        }

        // Getting monkeys type with input validation
        String type;
        do {
            System.out.println("What is the monkey type?");
            type = scanner.nextLine();
        } while (type.isEmpty());

        // Getting monkeys gender with input validation
        String gender;
        do {
            System.out.println("What is the monkey gender? Enter male, female or unknown");
            gender = scanner.nextLine();
        } while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")
                && !gender.equalsIgnoreCase("unknown"));

        // Getting monkeys age with input validation
        String age;
        do {
            System.out.println("What is the monkey age?");
            age = scanner.nextLine();
        } while (age.isEmpty());

        // Getting monkeys weight with input validation
        String weight;
        do {
            System.out.println("What is the monkey weight?");
            weight = scanner.nextLine();
        } while (weight.isEmpty());

        // Gets monkeys date of acquisition with regex format validation
        String acquisitionDate;
        do {
            System.out.println("What is the monkey acquisitionDate?");
            acquisitionDate = scanner.nextLine();
        } while (!acquisitionDate.matches("\\d{4}-\\d{2}-\\d{2}"));

        // Gets country of monkeys acquisition
        String acquisitionCountry;
        do {
            System.out.println("What is the monkey acquisitionCountry?");
            acquisitionCountry = scanner.nextLine();
        } while (acquisitionCountry.isEmpty());

        // Gets monkeys training status with format validation
        String trainingStatus;
        do {
            System.out.println("What is the monkey trainingStatus?");
            trainingStatus = scanner.nextLine();
        } while (!trainingStatus.equals("intake") && !trainingStatus.equals("in service"));

        // Validation to ensure user types either true or false
        String reserved;
        do {
            System.out.println("Is the monkey reserved? Enter true or false.");
            reserved = scanner.nextLine();
        } while (!reserved.equals("false") && !reserved.equals("true"));

        // Gets monkeys in service country with input validation
        String inServiceCountry;
        do {
            System.out.println("What is the monkey inServiceCountry?");
            inServiceCountry = scanner.nextLine();
        } while (inServiceCountry.isEmpty());

        // Extra type validation for monkey double attributes.
        // Monkey tail length validation.
        Double tailLength = 0.0;
        boolean tailLengthValid = false;
        do {
            System.out.println("What is the monkey tailLength?");
            try {
                tailLength = Double.parseDouble(scanner.nextLine());
                tailLengthValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please put a number in the folling format, 1, 2.4, 6, 10.34");
            }
        } while (!tailLengthValid);

        // Monkey height validation.
        Double height = 0.0;
        boolean heightValid = false;
        do {
            System.out.println("What is the monkey height?");
            try {
                height = Double.parseDouble(scanner.nextLine());
                heightValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please put a number in the folling format, 1, 2.4, 6, 10.34");
            }
        } while (!heightValid);

        // Monkey body length validation.
        Double bodyLength = 0.0;
        boolean bodyLengthValid = false;
        do {
            System.out.println("What is the monkey body length?");
            try {
                bodyLength = Double.parseDouble(scanner.nextLine());
                bodyLengthValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please put a number in the folling format, 1, 2.4, 6, 10.34");
            }
        } while (!bodyLengthValid);
        // New monkey instance with input variables
        Monkey newMonkey = new Monkey(name, type, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, Boolean.valueOf(reserved), inServiceCountry, tailLength, height, bodyLength, species);
        // Adding new monkey instance to monkey arraylist
        monkeyList.add(newMonkey);
        // User output feedback
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println(name + " has been added to the monkey list.");
    }

    // Reserve animal method
    public static void reserveAnimal(Scanner scanner) {
        clearConsole();
        String userInput;
        String reserveAnimal;
        // Makes sure user enters dog or monkey
        do {
            System.out.println("What type of animal would you like to reserve? Type dog or monkey");
            userInput = scanner.nextLine();
        } while (!userInput.equals("dog") && !userInput.equals("monkey"));
        // Prints all monkeys in service and not reserved
        if (userInput.equals("monkey")) {
            System.out.println();
            Boolean monkeyMatched;
            do {
                System.out.println("All avaiable monkeys");
                System.out.println("_________________________________________________");
                // Displays only the avaiable monkeys
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved() && monkey.getTrainingStatus().equals("in service")) {
                        System.out.println(monkey.getName());
                    }
                }
                System.out.println();

                // Reserves monkey if user provided name is a valid avaiable monkey or user
                // input is exit
                monkeyMatched = false;

                System.out.println(
                        "Type the name of the monkey you want to reserve? Type Monkey name OR exit to go back to main menu");
                reserveAnimal = scanner.nextLine();
                for (Monkey monkey : monkeyList) {
                    if (monkey.getName().equals(reserveAnimal)) {
                        monkey.setReserved(true);
                        System.out.println(monkey.getName() + " has been reserved");
                        System.out.println("_________________________________________________");
                    }
                }
            } while (!monkeyMatched && !reserveAnimal.equals("exit"));

            // Prints all dogs in service and not reserved
        } else if (userInput.equals("dog")) {
            System.out.println();
            System.out.println("All avaiable dogs");
            System.out.println("_________________________________________________");
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getTrainingStatus().equals("in service")) {
                    System.out.println(dog.getName());

                }
            }
            System.out.println();
            System.out.println("Type the name of the dog you want to reserve");
            reserveAnimal = scanner.nextLine();
            // Reserves dog
            for (Dog dog : dogList) {
                if (dog.getName().equals(reserveAnimal)) {
                    dog.setReserved(true);
                    System.out.println(dog.getName() + " has been reserved");
                    System.out.println("_________________________________________________");
                }
            }
        }
    }

    // Print animal method, check what list type to display
    public static void printAnimals(String listType) {
        // List all dogs
        if (listType.equals("dogs")) {
            clearConsole();
            System.out.println();
            System.out.println("All Dogs");
            System.out.println("_________________________________________________");
            for (Dog dog : dogList) {
                System.out.println(
                        "Name " + dog.getName() + ", Status " + dog.getTrainingStatus() + ", Acquisition Country "
                                + dog.getAcquisitionLocation() + ", Reservation Status " + dog.getReserved());
            }
            // Lists all monkeys
        } else if (listType.equals("monkeys")) {
            clearConsole();
            System.out.println();
            System.out.println("All Monkeys");
            System.out.println("_________________________________________________");
            for (Monkey monkey : monkeyList) {
                System.out.println(
                        "Name " + monkey.getName() + ", Status " + monkey.getTrainingStatus() + ", Acquisition Country "
                                + monkey.getAcquisitionLocation() + ", Reservation Status " + monkey.getReserved());
            }
            // Lists all dogs and monkeys that are in service but not reserved
        } else if (listType.equals("avaiable")) {
            clearConsole();
            System.out.println();
            System.out.println("All Avaiable Animals");
            System.out.println("_________________________________________________");
            for (Dog dog : dogList) {
                // Checks that the reserve is false and that the traing status is in service
                if (!dog.getReserved() && dog.getTrainingStatus().equals("in service")) {
                    System.out.println(
                            "Name " + dog.getName() + ", Status " + dog.getTrainingStatus() + ", Acquisition Country "
                                    + dog.getAcquisitionLocation() + ", Reservation Status " + dog.getReserved());
                }
            }
            for (Monkey monkey : monkeyList) {
                // Checks that the reserve is false and that the traing status is in service
                if (!monkey.getReserved() && monkey.getTrainingStatus().equals("in service")) {
                    System.out.println("Name " + monkey.getName() + ", Status " + monkey.getTrainingStatus()
                            + ", Acquisition Country " + monkey.getAcquisitionLocation() + ", Reservation Status "
                            + monkey.getReserved());
                }
            }
        }

    }
}
